import java.util.*;
class Solution {
    private static int[] parent;
    
    public static int findParent(int n){
        if(n==parent[n]){
            return n;
        }
        
        return parent[n]=findParent(parent[n]);
    }
    public static void union(int x,int y){
        int root1=findParent(x);
        int root2=findParent(y);
        parent[root2]=root1;
    }
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs,(o1,o2)->{
            return o1[2]-o2[2];
        });
        
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        int answer=0;
        int edges=0;
        
        for(int[] edge:costs){
            if(edges==n-1){
                break;
            }
            
            if(findParent(edge[0])!=findParent(edge[1])){
                union(edge[0],edge[1]);
                answer+=edge[2];
                edges++;
            }
        }
        return answer;
    }
}