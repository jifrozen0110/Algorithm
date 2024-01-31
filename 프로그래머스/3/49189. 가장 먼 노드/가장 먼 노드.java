import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        
        int[] visited=new int[n+1];
        for(int i=0;i<n+1;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0;i<edge.length;i++){
            arr.get(edge[i][0]).add(edge[i][1]);
            arr.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(1);
        visited[1]=1;
        while(!q.isEmpty()){
            int num=q.poll();
            for(int i=0;i<arr.get(num).size();i++){
                if(visited[arr.get(num).get(i)]==0){
                    visited[arr.get(num).get(i)]=visited[num]+1;
                    q.offer(arr.get(num).get(i));
                }
            }
        }
        
        Arrays.sort(visited);
        
        int max=visited[visited.length-1];
        
        for(int i=visited.length-1;i>=0;i--){
            if(visited[i]==max){
                answer++;
            }
        }
        return answer;
    }
}