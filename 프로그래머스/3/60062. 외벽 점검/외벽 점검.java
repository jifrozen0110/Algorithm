import java.util.*;
class Solution {
    private static int length,answer;
    private static int[] Weak;
    private static boolean[] used;
    
    private static boolean check(int[] dist){
        for(int i=0;i<length;i++){
            int index=i;
            
            for(int distance:dist){
                int d=distance+Weak[index++];
                while(index<Weak.length&&d>=Weak[index]){
                    index++;
                }
            }
            
            if(index-i>=length){
                return true;
            }
        }
        return false;
    }
    private static void DFS(int n,int[] dist,int[] org){
        if(n==org.length){
            if(check(dist)){
                answer=dist.length;
            }
            return;
        }
        
        for(int i=0;i<org.length;i++){
            if(!used[i]){
                used[i]=true;
                dist[n]=org[i];
                DFS(n+1,dist,org);
                used[i]=false;
            }
        }
    }
    public int solution(int n, int[] weak, int[] dist) {
        answer = -1;
        length=weak.length;
        
        Weak=new int[weak.length*2];
        
        for(int i=0;i<2;i++){
            for(int j=0;j<length;j++){
                Weak[i*length+j]=weak[j]+i*n;
            }
        }
        
        Arrays.sort(dist);
         
        used=new boolean[dist.length];
        
        for(int i=1;i<=dist.length;i++){
            int[] org=new int[i];
            System.arraycopy(dist,dist.length-i,org,0,i);
            DFS(0,new int[i],org);
            if(answer!=-1){
                return answer;
            }
        }
        
        
        
        return answer;
    }
}