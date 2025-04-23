import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        
        for (int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }
        
        for (int[] e:edge){
            arr.get(e[0]).add(e[1]);
            arr.get(e[1]).add(e[0]);
        }
        
        Queue<int[]> q=new LinkedList<>();
        int[] path=new int[n+1];
        path[1]=1;
        q.add(new int[]{1,0});
        while(!q.isEmpty()){
            int[] start=q.poll();
            
            for (int i=0;i<arr.get(start[0]).size();i++){
                if (path[arr.get(start[0]).get(i)]==0){
                    path[arr.get(start[0]).get(i)]=path[start[0]]+1;
                    q.add(new int[]{arr.get(start[0]).get(i),path[start[0]]+1});
                }
            }
            
        }
                
        int m=Arrays.stream(path).max().getAsInt();
        for (int i=0;i<path.length;i++){
            if(m==path[i]){
                answer++;
            }
        }
        return answer;
    }
}