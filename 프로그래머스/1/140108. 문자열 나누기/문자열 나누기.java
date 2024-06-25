class Solution {
    public int solution(String s) {
        int answer = 1;
        
        char standard=s.charAt(0);
        int max=1;
        for(int i=1;i<s.length();i++){
            if(max==0){
                answer++;
                standard=s.charAt(i);
                max=1;
                continue;
            }
            if(standard==s.charAt(i)){
                max++;
            }else{
                max--;
            }
            
        }
        
        return answer;
    }
}