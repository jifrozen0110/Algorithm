class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int prev=0;
        for(int s:section){
            if(s>prev){
                answer++;
                prev=s+(m-1);
            }
        }
        return answer;
    }
}