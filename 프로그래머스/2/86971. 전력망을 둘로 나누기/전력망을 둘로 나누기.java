import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int[][] wiresArr=new int[n+1][n+1];
        
        for(int i=0;i<n-1;i++){
            wiresArr[wires[i][0]][wires[i][1]]=1;
            wiresArr[wires[i][1]][wires[i][0]]=1;
        }
        
        for(int i=0;i<n-1;i++){
            wiresArr[wires[i][0]][wires[i][1]]=0;
            wiresArr[wires[i][1]][wires[i][0]]=0;
            
            int result=bfs(wiresArr,wires[i][0],n);
            
            answer=Math.min(answer,Math.abs(result-(n-result)));
            
            wiresArr[wires[i][0]][wires[i][1]]=1;
            wiresArr[wires[i][1]][wires[i][0]]=1;
        }
        return answer;
    }
    
    public int bfs(int[][] arr,int start,int n){
        int result=1;
        
        int[] visited=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(start);
        visited[start]=1;
        
        while(!q.isEmpty()){
            int a=q.poll();
            for(int i=1;i<=n;i++){
                if(arr[a][i]==1&&visited[i]==0){
                    visited[i]=1;
                    result++;
                    q.add(i);
                }
            }
        }
        
        return result;
        
    }
}