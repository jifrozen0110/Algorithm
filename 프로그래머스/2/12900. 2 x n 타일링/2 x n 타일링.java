class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] tile=new int[n+1];
        
        tile[1]=1;
        tile[2]=2;
        
        for(int i=3;i<=n;i++){
            tile[i]=tile[i-1]%1000000007+tile[i-2]%1000000007;
        }
        return tile[n]%1000000007;
    }
}