import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=order.length;i++){
            q.add(i);
        }
        
        Stack<Integer> stack=new Stack<>();
        
        int cur=1;
        for(int i=0;i<order.length;i++){
            while(!q.isEmpty()&&q.peek()<order[i]){
                stack.push(q.poll());
            }
            if(!q.isEmpty()&&q.peek()==order[i]){
                q.poll();
                answer++;
                continue;   
            }
            if(!stack.isEmpty()&&stack.pop()!=order[i]){
                break;
            }
            answer++;
        }
        return answer;
    }
}