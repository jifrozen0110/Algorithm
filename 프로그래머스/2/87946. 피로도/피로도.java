class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        
        DFS(new boolean[dungeons.length],k,dungeons,0);
        
        return answer;
    }
    public void DFS(boolean[] visited,int total,int[][] dungeons,int count){
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]&&total>=dungeons[i][0]){
                visited[i]=true;
                answer=Math.max(answer,count+1);
                DFS(visited,total-dungeons[i][1],dungeons,count+1);
                visited[i]=false;
            }
        }
    }
} 