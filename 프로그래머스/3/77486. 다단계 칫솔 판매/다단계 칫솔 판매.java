import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String,Integer> personToPrice=new HashMap<>();
        HashMap<String,String> childToParent=new HashMap<>();
        
        for(String e:enroll){
            personToPrice.put(e,0);
        }
        
        for(int i=0;i<referral.length;i++){
            if(referral[i].equals("-")) continue;
            childToParent.put(enroll[i],referral[i]);
        }
        
        for(int i=0;i<seller.length;i++){
            int price=amount[i]*100;
            int tenpercentage=price/10;
            String current=seller[i];
            personToPrice.put(current,personToPrice.get(current)+(price-tenpercentage));
            while(tenpercentage>0&&childToParent.containsKey(current)){
                price=tenpercentage;
                tenpercentage/=10;
                current=childToParent.get(current);
                personToPrice.put(current,personToPrice.get(current)+(price-tenpercentage));
            }
            
        }
        
        for(int i=0;i<enroll.length;i++){
            answer[i]=personToPrice.get(enroll[i]);
        }
        
        return answer;
    }
}