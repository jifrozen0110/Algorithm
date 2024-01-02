class Solution {
    public int solution(String name) {
        int answer = 0;
        int len=name.length();
        
        int move=len-1;
        for(int i=0;i<len;i++){
            answer+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            
            int index=i+1;
            while(index<len&&name.charAt(index)=='A'){
                index++;
            }
            
            move=Math.min(move,i*2+(len-index));
            move=Math.min(move,i+(len-index)*2);
        }

        return answer+move;
    }
}