import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        HashSet<String> set=new HashSet<>();
        
        int index=0;
        char last=words[0].charAt(0);
        for(String word:words){
            if(set.contains(word)){
                break;
            }
            if(word.length()==1) break;
            if(last!=word.charAt(0)) break;
            last=word.charAt(word.length()-1);
            set.add(word);
            index++;
        }
        

        if(set.size()==words.length) return new int[]{0,0};
        return new int[]{index%n+1,index/n+1};
    }
}