import java.util.*;
class Solution {
    static HashMap<String,Integer> map=new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        
        
        for(int i=0;i<9;i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
        
        int index=0;
        
        for(int i=9;i<discount.length;i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
            if(isDiscount(want,number)){
                answer++;
            }
            map.put(discount[index],map.get(discount[index])-1);
            index++;
        }
        
        return answer;
    }
    
    public boolean isDiscount(String[] want,int[] number){
        
        for(int i=0;i<want.length;i++){
            if(map.containsKey(want[i])){
                if(map.get(want[i])<number[i]){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
}