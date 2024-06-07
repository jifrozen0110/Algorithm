import java.util.*;
class Solution {
    private static final int INF=20_001;
    public int solution(String[] strs, String t) {
        int answer = 0;
        
        HashSet<Integer> set=new HashSet<>();
        HashSet<String> strSet=new HashSet<>(Arrays.asList(strs));
        int[] dp=new int[t.length()+1];
        for(String str:strs){
            set.add(str.length());
        }
        
        Arrays.fill(dp,INF);
        
        dp[0]=0;
        
        for(int i=1;i<t.length()+1;i++){
            for(int size:set){
                if(i-size>=0){
                    String s=t.substring(i-size,i);
                    if(strSet.contains(s)){
                        dp[i]=Math.min(dp[i-size]+1,dp[i]);
                    }
                }
                
            }
        }
        
        return dp[t.length()]>=INF?-1:dp[t.length()];
    }
}