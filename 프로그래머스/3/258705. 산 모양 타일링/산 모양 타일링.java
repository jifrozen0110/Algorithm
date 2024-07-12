class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        // \\ 모양 dp
        int[] a=new int[n+1];
        // \\ 모양이 빠진 dp
        int[] b=new int[n+1];
        
        a[1]=1;
        if(tops[0]==1){
            b[1]=3;
        }else{
            b[1]=2;
        }
        
        for(int i=2;i<n+1;i++){
            if(tops[i-1]==1){
                a[i]=(a[i-1]+b[i-1])%10007;
                b[i]=(a[i-1]*2+b[i-1]*3)%10007;
            }else{
                a[i]=(a[i-1]+b[i-1])%10007;
                b[i]=(a[i-1]+b[i-1]*2)%10007;
           }
        }
        
        
        
        return (a[n]+b[n])%10007;
    }
}