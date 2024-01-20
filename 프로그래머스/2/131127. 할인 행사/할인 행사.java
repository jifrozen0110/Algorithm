import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> wantMap=new HashMap<>();
        
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i],number[i]);
        }
        
        HashMap<String,Integer> tempMap=new HashMap<>();
        for(int i=0;i<10;i++){
            tempMap.put(discount[i],tempMap.getOrDefault(discount[i],0)+1);
        }
        
        if (check(wantMap, tempMap)) answer++;
        
        for(int i=1;i<discount.length-9;i++){
            String previousKey = discount[i - 1];
            int end=i+9;
            tempMap.put(previousKey,tempMap.get(previousKey)-1);
            if (tempMap.get(previousKey) == 0) {
            tempMap.remove(previousKey);
        }
            tempMap.put(discount[end],tempMap.getOrDefault(discount[end],0)+1);
            
        if (check(wantMap, tempMap)) answer++;
            
        }
        
        return answer;
    }
    public static boolean check(Map<String, Integer> target, Map<String, Integer> map) {
        for (String key: map.keySet()) {
            if (!target.containsKey(key) || map.get(key) != target.get(key)) return false;
        }
        return true;
    }
}