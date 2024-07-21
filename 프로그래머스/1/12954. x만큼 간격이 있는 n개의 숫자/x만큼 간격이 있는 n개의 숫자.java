class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int index=0;
        for(int i=0;i<n;i++){
            answer[index++]=(long) x*(i+1);
        }
        return answer;
    }
}