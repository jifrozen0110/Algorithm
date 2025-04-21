class Solution {
    static int count=0;
    public int solution(int n, int[][] wires) {
        int answer = 101;
//         System.out.println();
        
        int[][] map=new int[n+1][n+1];
        for (int[] wire:wires){
            map[wire[0]][wire[1]]=1;
            map[wire[1]][wire[0]]=1;
        }

        for (int[] wire:wires){
            count=1;
            boolean[] visited=new boolean[n+1];
            map[wire[0]][wire[1]]=0;
            map[wire[1]][wire[0]]=0;
            DFS(wire[0],visited,map);
            map[wire[0]][wire[1]]=1;
            map[wire[1]][wire[0]]=1;
            answer=Math.min(Math.abs((n-count)-count),answer);
        }
        
        return answer;
    }
    public void DFS(int start,boolean[] visited,int[][] map){
        visited[start]=true;
        for (int i=1;i<map.length;i++){
            if (map[start][i]==1 && !visited[i]){
                count++;
                DFS(i,visited,map);
            }
        }
        return;
    }
}