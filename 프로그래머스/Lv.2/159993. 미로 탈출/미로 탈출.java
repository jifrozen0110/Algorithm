import java.util.*;
class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int col,len,answer=0;
    static char[][] mapChar;
    public int solution(String[] maps) {
        
        int sx=0,sy=0,lx=0,ly=0,ex=0,ey=0;
        col=maps.length;
        len=maps[0].length();
        
        // S:시작 지점 / L:레버 / E:출구 좌표 저장
        // map 프로세싱
        mapChar=new char[col][len];
        for(int i=0;i<maps.length;i++){
            String map=maps[i];
            for(int j=0;j<len;j++){
                mapChar[i][j]=map.charAt(j);
                if(map.charAt(j)=='S'){
                    sx=i;sy=j;
                }
                if(map.charAt(j)=='E'){
                    ex=i;ey=j;
                }
                if(map.charAt(j)=='L'){
                    lx=i;ly=j;
                }
            }
        }
        
        // S에서 L까지
        int result=BFS(sx,sy,lx,ly);
        if(result==-1) return -1;
        answer+=result;
        // L에서 E까지
        result=BFS(lx,ly,ex,ey);
        if(result==-1) return -1;
        answer+=result;
        
        return answer;
    }
    
    public int BFS(int sx,int sy,int ex,int ey){
        int[][] visited=new int[col][len];
        
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        
        qx.offer(sx);
        qy.offer(sy);
        visited[sx][sy]=0;
        
        while(!qx.isEmpty()){
            int currentX=qx.poll();
            int currentY=qy.poll();
            for(int i=0;i<4;i++){
                int nx=currentX+dx[i];
                int ny=currentY+dy[i];
                if(nx<0||ny<0||nx>=col||ny>=len) continue;
                if(mapChar[nx][ny]=='X') continue;
                if(visited[nx][ny]!=0) continue;
                visited[nx][ny]=visited[currentX][currentY] +1;
                if(nx==ex&&ny==ey){
                    return visited[nx][ny];
                }
                qx.offer(nx);
                qy.offer(ny);
            }
        }
        
        return -1;
        
    }
}