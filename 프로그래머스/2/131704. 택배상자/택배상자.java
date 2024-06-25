import java.util.*;
class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> stack=new Stack<>();
        
        int idx=0;
        for(int i=0;i<order.length;i++){
            stack.push(i+1);
            
            while(!stack.isEmpty()){
                if(stack.peek()==order[idx]){
                    stack.pop();
                    idx++;
                }else break;
            }
        }
        
        return idx;
    }
}