class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n];
        
        for (int i=0;i<n;i++){
            if (!visited[i]){
                visited[i]=true;
                DFS(visited,i,n,computers);
                answer++;
            }
        }
        
        
        return answer;
    }
    public static void DFS(boolean[] visited,int index,int n,int[][] map){
        for (int i=0;i<n;i++){
            if(map[index][i]==1&&!visited[i]){
                visited[i]=true;
                DFS(visited,i,n,map);
            }
        }
        return;
    }
}