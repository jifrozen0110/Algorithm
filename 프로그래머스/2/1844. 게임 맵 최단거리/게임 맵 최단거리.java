import java.util.*;
class Solution {
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        
        int col=maps.length,row=maps[0].length;
        int[][] visited=new int[col][row];
        Queue<int[]> q=new LinkedList<>();
        
        int curX=0,curY=0;
        visited[curX][curY]=1;
        q.offer(new int[] {curX,curY});
        
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int i=0;i<4;i++){
                int nextX=node[0]+dx[i];
                int nextY=node[1]+dy[i];
                if(nextX<0||nextY<0||nextX>=col||nextY>=row){
                    continue;
                }
                if(visited[nextX][nextY]!=0) continue;
                if(maps[nextX][nextY]==0) continue;
                visited[nextX][nextY]=visited[node[0]][node[1]]+1;
                q.offer(new int[] {nextX,nextY});
            }
        }
        
        return (visited[col-1][row-1]==0)?-1:visited[col-1][row-1];
    }
}