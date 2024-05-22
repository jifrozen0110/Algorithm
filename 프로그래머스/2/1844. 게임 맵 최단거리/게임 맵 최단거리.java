import java.util.*;
class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        int[][] visited=new int[maps.length][maps[0].length];
        visited[0][0]=1;
        
        while(!q.isEmpty()){
            int[] current=q.poll();
            for(int d=0;d<4;d++){
                int nx=current[0]+dx[d];
                int ny=current[1]+dy[d];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length){
                    continue;
                }
                if(visited[nx][ny]!=0) continue;
                if(maps[nx][ny]==0) continue;
                q.add(new int[]{nx,ny});
                visited[nx][ny]=visited[current[0]][current[1]]+1;
            }
        }
        
        // return 0;
        return visited[maps.length-1][maps[0].length-1]==0?-1:visited[maps.length-1][maps[0].length-1];
    }
}