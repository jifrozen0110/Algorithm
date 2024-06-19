import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0;i<s.length;i++){
            String str=s[i];
            int count=0;
            StringBuilder sb=new StringBuilder();
            Stack<Character> stack=new Stack<>();
           for (char c : str.toCharArray()) {
                stack.push(c);
                
                if (stack.size() >= 3) {
                    char third = stack.pop();
                    char second = stack.pop();
                    char first = stack.pop();
                    
                    if (first == '1' && second == '1' && third == '0') {
                        count++;
                    } else {
                        stack.push(first);
                        stack.push(second);
                        stack.push(third);
                    }
                }
            }
            
            int[] indexes=new int[count];
            boolean flag=false;
            int index=stack.size();
            while(!stack.isEmpty()){
                char c=stack.pop();
                if(!flag){
                    if(c=='1'){
                        index--;
                    }else{
                        flag=true;
                    }
                }
            
                sb.insert(0,c);
            }
            
            while(count>0){
                count--;
                sb.insert(index,"110");
                index+=3;
            }
            
            answer[i]=sb.toString();
            
        }
        return answer;
    }
}