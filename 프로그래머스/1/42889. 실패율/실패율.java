import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] people=new int[N+2];
        
        for(int i=0;i<stages.length;i++){
            people[stages[i]]+=1;
        }
        
        double total=stages.length;
        
        HashMap<Integer,Double> failRate=new HashMap<>();
        for(int i=1;i<=N;i++){
            if(people[i]==0){
                failRate.put(i,0.0);
            }else{
                failRate.put(i,people[i]/total);
                total-=people[i];
            }
        }
        return failRate.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}