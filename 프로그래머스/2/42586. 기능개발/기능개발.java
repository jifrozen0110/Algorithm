import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer=new ArrayList<>();
        
        int day=0;
        LinkedHashMap<Integer,Integer> dayToDone=new LinkedHashMap<>();
        for(int i=0;i<progresses.length;i++){
            int progress=progresses[i];
            int speed=speeds[i];
            
            while(progress+speed*day<100){
                day++;
            }
            dayToDone.put(day,dayToDone.getOrDefault(day,0)+1);
            
        }
        return dayToDone.values().stream().mapToInt(Integer::intValue).toArray();
    }
}