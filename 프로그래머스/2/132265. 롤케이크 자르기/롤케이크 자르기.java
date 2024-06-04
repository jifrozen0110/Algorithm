import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> right=new HashMap<>();
        HashMap<Integer,Integer> left=new HashMap<>();
        
        for(int t:topping){
            left.put(t,left.getOrDefault(t,0)+1);
        }
        
        for(int t:topping){
            right.put(t,right.getOrDefault(t,0)+1);
            left.put(t,left.get(t)-1);
            if(left.get(t)==0){
                left.remove(t);
            }
            if(right.size()==left.size()){
                answer++;
            }
        }
        return answer;
    }
}