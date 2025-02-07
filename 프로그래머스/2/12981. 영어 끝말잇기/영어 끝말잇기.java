import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        
        char lastWord=words[0].charAt(0);
        
        HashSet<String> ms=new HashSet<String>();
    
        for (int i=0;i<words.length;i++){
            if (words[i].length()<=1){
                answer[0]=(i)%n+1;
                answer[1]=((i)/n)+1;
                return answer;
            }
            if (ms.contains(words[i])){
                answer[0]=(i)%n+1;
                answer[1]=((i)/n)+1;
                return answer;
            }
            if (words[i].charAt(0)!=lastWord){
                answer[0]=(i)%n+1;
                answer[1]=((i)/n)+1;
                return answer;
            }
            ms.add(words[i]);
            lastWord=words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}