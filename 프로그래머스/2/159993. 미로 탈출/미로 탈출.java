import java.util.*;
class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int col,row;
    static char[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        map=new char[maps.length][maps[0].length()];
        col=maps.length;row=maps[0].length();
        int startX=0,startY=0,labberX=0,labberY=0,endX=0,endY=0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                map[i][j]=maps[i].charAt(j);
                if(map[i][j]=='S'){
                    startX=i;
                    startY=j;
                }else if(map[i][j]=='E'){
                    endX=i;
                    endY=j;
                }else if(map[i][j]=='L'){
                    labberX=i;
                    labberY=j;
                }
            }
        }
        
        answer=BFS(startX,startY,'L');
        if(answer==0) return -1;
        int temp=BFS(labberX,labberY,'E');
        if(temp==0) return -1;
        answer+=temp;
        
        return answer;
    }
    private static int BFS(int startX,int startY,char target){
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        q.add(new int[]{startX,startY});
        int[][] visited=new int[col][row];
        visited[startX][startY]=0;
        
        while(!q.isEmpty()){
            int[] current=q.poll();
            int x=current[0];
            int y=current[1];
            for(int d=0;d<4;d++){
                int nx=current[0]+dx[d];
                int ny=current[1]+dy[d];
                if(nx<0||ny<0||nx>=col||ny>=row) continue;
                if(map[nx][ny]=='X') continue;
                if(visited[nx][ny]!=0) continue;
                visited[nx][ny]=visited[x][y]+1;
                q.add(new int[]{nx,ny});
                if(map[nx][ny]==target) return visited[nx][ny];
            }
        }
        
        return 0;
    }
}