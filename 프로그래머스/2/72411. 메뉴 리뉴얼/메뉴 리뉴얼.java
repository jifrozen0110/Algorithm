import java.util.*;
class Solution {
    static HashMap<String,Integer> map=new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        for(int i=0;i<orders.length;i++){
            char[] charArray=orders[i].toCharArray();
            Arrays.sort(charArray);
            orders[i]=new String(charArray);
        }
        
        for(String order:orders){
            for(int c:course){
                DFS(order,0,c,new StringBuilder());
            }
        }
        ArrayList<String> arr=new ArrayList<>();
       
        for(int c:course){
            int maxCount=0;
            for(String key:map.keySet()){
                if(key.length()==c){
                    maxCount=Math.max(maxCount,map.get(key));
                }
            }
            
            for(String key:map.keySet()){
                if(key.length()==c&&map.get(key)==maxCount&&maxCount>1){
                    arr.add(key);
                }
            }
        }
        
        String[] answer=new String[arr.size()];
        answer=arr.toArray(answer);
        Arrays.sort(answer);
        
        return answer;
    }
    public void DFS(String order,int index,int course,StringBuilder sb){
        if(course==sb.length()){
            String target=sb.toString();
            map.put(target,map.getOrDefault(target,0)+1);
        }
        
        for(int i=index;i<order.length();i++){
            sb.append(order.charAt(i));
            DFS(order,i+1,course,sb);
            sb.deleteCharAt(sb.length()-1);
                
        }
    }
}