import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String p:completion){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        
        for(String p:participant){
            if(!map.containsKey(p)){
                return p;
            }
            map.put(p,map.get(p)-1);
            if(map.get(p)<0) return p;
        }
        
        
        return answer;
    }
}