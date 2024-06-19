import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer=new StringBuilder();
        char[] sArr=s.toCharArray();
        
        HashSet<Character> set=new HashSet<>();
        for(char c:skip.toCharArray()){
            set.add(c);
        }
        int idx=index;
        
        for(char c:sArr){
            idx=index;
            char temp=c;
            for(int i=1;i<=idx;i++){
                temp=(char)(temp+1)>'z'?'a':(char)(temp+1);
                if(set.contains(temp)){
                    idx++;
                }
                
            }
            answer.append(temp);
            
                
        }
        return answer.toString();
    }
}