import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(String key:keymap){
            for(int i=0;i<key.length();i++){
                if(map.containsKey(key.charAt(i))){
                    int min=Math.min(map.get(key.charAt(i)),i+1);
                    map.put(key.charAt(i),min);
                }else{
                    map.put(key.charAt(i),i+1);
                }
            }
        }
        
        int idx=0;
        for(String target:targets){
            int result=0;
            for(char c:target.toCharArray()){
                if(!map.containsKey(c)){
                    result=-1;
                    break;
                }
                result+=map.get(c);
            }
            answer[idx++]=result;
        }
        return answer;
    }
}