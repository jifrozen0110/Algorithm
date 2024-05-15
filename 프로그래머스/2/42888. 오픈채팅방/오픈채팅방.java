import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        
        ArrayList<String[]> messages=new ArrayList<>();
        HashMap<String,String> name=new HashMap<>();
        
        for(String r:record){
            String[] arr=r.split(" ");
            if(arr[0].equals("Enter")){
                String uid=arr[1];
                String nickName=arr[2];
                name.put(uid,nickName);
                messages.add(new String[]{uid,"님이 들어왔습니다."});
            }else if(arr[0].equals("Change")){
                String uid=arr[1];
                String nickName=arr[2];
                name.put(uid,nickName);
            }else{
                String uid=arr[1];
                messages.add(new String[]{uid,"님이 나갔습니다."});
            }
            
        }
        
        String[] answer = new String[messages.size()];
        
        for(int i=0;i<messages.size();i++){
            String[] message=messages.get(i);
            answer[i]=name.get(message[0])+message[1];
        }
        return answer;
    }
}