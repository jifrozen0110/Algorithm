package DFS_BFS;

import java.util.*;
class Solution {
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int count =0;
    public int solution(int[][] land) {
        int answer = 0;
        int index=2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1){
                    land[i][j]=index;
                    count=1;
                    DFS(land,index,i,j);
                    map.put(index,count);
                    index++;
                }
            }
        }

        int[] visited=new int[land[0].length];

        for(int i=0;i<land[0].length;i++){
            int result=0;
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<land.length;j++){
                if(land[j][i]!=0){
                    set.add(land[j][i]);
                }
            }
            if(set.size()==0||set.isEmpty()){
                continue;
            }
            for(int in:set){
                result+=map.getOrDefault(in,0);
            }
            visited[i]=result;
        }

        return Arrays.stream(visited).max().getAsInt();
    }
    public void DFS(int[][] land,int index,int x,int y){
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=land.length||ny>=land[0].length) continue;
            if(land[nx][ny]==1){
                land[nx][ny]=index;
                count++;
                DFS(land,index,nx,ny);
            }
        }


    }
}