import java.util.*;
class Solution {
    static int[] uf;
    public int find(int a){
        if (uf[a]<0){
            return a;
        }
        a=find(uf[a]);
        return a;
    }
    public void merge(int a,int b){
        int p_a=find(a);
        int p_b=find(b);
        if (p_a==p_b){
            return;
        }
        uf[p_a]+=uf[p_b];
        uf[p_b]=p_a;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        
        for (int i=0;i<wires.length;i++){
            uf=new int[n+1];
            Arrays.fill(uf,-1);
            for (int j=0;j<wires.length;j++){
                if (i==j){
                    continue;
                }
                merge(wires[j][0],wires[j][1]);
            }
            int[] temp=new int[2];
            int index=0;
            for (int j=1;j<uf.length;j++){
                if(uf[j]<0){
                    temp[index]=uf[j];
                    index++;
                }
            }
            
            answer=Math.min(answer,Math.abs(temp[0]-temp[1]));
        }
        return answer;
    }
}