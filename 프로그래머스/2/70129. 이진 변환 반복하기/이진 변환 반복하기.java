class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(true){
            if(s.length()==1){
                break;
            }
            int origin=s.length();
            s=s.replace("0","");
            answer[1]+=origin-s.length();
            s=Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}