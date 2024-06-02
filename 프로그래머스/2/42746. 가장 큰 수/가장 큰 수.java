import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] arr=new String[numbers.length];
        int index=0;
        for(int number:numbers){
            arr[index++]=String.valueOf(number);
        }
        
        Arrays.sort(arr,(a,b)->{
            int o1=Integer.parseInt(a+b);
            int o2=Integer.parseInt(b+a);
            return Integer.compare(o2,o1);
        });
        
        StringBuilder sb=new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        
        if(sb.charAt(0)=='0'){
            return "0";
        }
                
            
        return sb.toString();
    }
}