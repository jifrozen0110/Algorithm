import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    static int total;
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] wires) {
        answer=n;
        total=n;
        arr=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }
        
        for(int[] wire:wires){
            arr[wire[0]].add(wire[1]);
            arr[wire[1]].add(wire[0]);
        }
        
        visited=new boolean[n+1];
        
        DFS(1);
        
        return answer;
    }
    private static int DFS(int start){
        visited[start]=true;
        int sum=0;
        for(int i=0;i<arr[start].size();i++){
            if(!visited[arr[start].get(i)]){
                int count=DFS(arr[start].get(i));
                
                answer=Math.min(Math.abs(count-(total-count)),answer);
                
                sum+=count;
            }
            
        }
        
        return sum+1;
    }
}