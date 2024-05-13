import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n=s.length();
        s+=s;
        
        
        for(int i=0;i<n;i++){
            Deque<Character> stack=new ArrayDeque<>();
            boolean isRight=true;
            for(int j=i;j<i+n;j++){
                char c=s.charAt(j);
                if(c=='['||c=='{'||c=='('){
                    stack.addFirst(c);
                }
                if(c==']'){
                    if(stack.isEmpty()){
                        isRight=false;
                        break;
                    }
                    if(stack.removeFirst()!='['){
                        isRight=false;
                        break;
                    }
                }
                if(c=='}'){
                    if(stack.isEmpty()){
                        isRight=false;
                        break;
                    }
                    if(stack.removeFirst()!='{'){
                        isRight=false;
                        break;
                    }
                }
                if(c==')'){
                    if(stack.isEmpty()){
                        isRight=false;
                        break;
                    }
                    if(stack.removeFirst()!='('){
                        isRight=false;
                        break;
                    }
                }
                
            }
            if(!stack.isEmpty()){
                isRight=false;
            }
            if(isRight){
                answer++;
            }
        }
        return answer;
    }
}