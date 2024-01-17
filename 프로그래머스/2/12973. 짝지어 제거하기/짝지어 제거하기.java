import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        if(s.length()%2==1) return answer;
        
        Stack<Character> stack=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(stack.size()==0){
                stack.push(c);
            }else{
                char prev=stack.pop();
                if(prev!=c){
                    stack.push(prev);
                    stack.push(c);
                }
            }
        }
        
        if(stack.size()==0){
            answer=1;
        }
        
        return answer;
    }
}