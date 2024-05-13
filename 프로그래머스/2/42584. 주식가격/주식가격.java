import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty()&&prices[stack.peekFirst()]>prices[i]){
                int prev=stack.removeFirst();
                answer[prev]=i-prev;
            }
            stack.addFirst(i);
        
        }
        
        
        int sec=prices.length-1;
        while(!stack.isEmpty()){
            int current=stack.removeFirst();
            answer[current]=sec-current;
        }
        
        return answer;
    }
}