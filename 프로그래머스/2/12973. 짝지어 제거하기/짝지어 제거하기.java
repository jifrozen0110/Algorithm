import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Deque<Character> stack=new ArrayDeque<>();
        
        for(char c:s.toCharArray()){
            if(stack.isEmpty()){
                stack.addFirst(c);
            }
            else if(stack.peekFirst()==c){
                stack.removeFirst();
            }else{
                stack.addFirst(c);
            }
        }
        
        if(!stack.isEmpty()){
            return 0;
        }
        
        return 1;
    }
}