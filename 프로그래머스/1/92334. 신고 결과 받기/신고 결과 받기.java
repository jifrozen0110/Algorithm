import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고한 사람
        HashMap<String,HashSet<String>> reportP=new HashMap<>();
        
        // 메일 받은 횟수
        HashMap<String,Integer> mail=new HashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            mail.put(id_list[i],0);
            reportP.put(id_list[i],new HashSet<String>());
        }
        
        for(String r:report){
            String[] ra=r.split(" ");
            String good=ra[0];
            String bad=ra[1];

            reportP.get(bad).add(good);
        }
        
        for(int i=0;i<id_list.length;i++){
            if(reportP.get(id_list[i]).size()>=k){
                HashSet<String> mailList=reportP.get(id_list[i]);
                for(String m:mailList){
                    mail.put(m,mail.get(m)+1);
                }
            }
        }
        
        for(int i=0;i<id_list.length;i++){
            answer[i]=mail.get(id_list[i]);
        }
        
        
        return answer;
    }
}