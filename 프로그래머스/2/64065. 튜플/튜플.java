import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        
        s=s.substring(0,s.length()-2).replace("{","");
        String[] arr=s.split("},");
        
        Arrays.sort(arr,(o1,o2)->{
            return o1.length()-o2.length();
        });
        
        HashSet<String> set=new HashSet<>(); 
        int[] answer = new int[arr.length];
        int index=0;
        for(String a:arr){
            String[] temp=a.split(",");
            for(String t:temp){
                if(!set.contains(t)){
                    set.add(t);
                    answer[index++]=Integer.parseInt(t);
                }
            }
        }
        
        return answer;
    }
}