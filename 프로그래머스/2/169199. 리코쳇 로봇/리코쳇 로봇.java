import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public int solution(String[] board) {
        int answer = 0;
        char[][] map=new char[board.length][board[0].length()];
        boolean[][] visited=new boolean[board.length][board[0].length()];
        int len=Math.max(board.length,board[0].length());
        int row=board.length;
        int col=board[0].length();
        
        int startX=0,startY=0,goalX=0,goalY=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                map[i][j]=board[i].charAt(j);
                if(map[i][j]=='R'){
                    startX=i;
                    startY=j;
                }else if(map[i][j]=='G'){
                    goalX=i;
                    goalY=j;
                }
            }
        }
        
        Queue<int[]> q=new LinkedList<>();
        
        visited[startX][startY]=true;
        q.add(new int[]{startX,startY,0});
        
        while(!q.isEmpty()){
            int[] pos=q.poll();
            int x=pos[0];
            int y=pos[1];
            int cnt=pos[2];
            if(x==goalX&&y==goalY){
                return cnt;
            }
            for(int i=0;i<4;i++){
                int nx=x,ny=y;
                while(true){
                    nx+=dx[i];
                    ny+=dy[i];
                    if(nx>=row||ny>=col||nx<0||ny<0||map[nx][ny]=='D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                }
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,cnt+1});
                }
            }
        }
        
        
        
        return -1;
    }
}