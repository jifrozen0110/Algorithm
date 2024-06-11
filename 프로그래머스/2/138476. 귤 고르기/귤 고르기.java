import java.util.*;
class Solution {
    class Tangerine implements Comparable<Tangerine>{
        int num;
        int count;
        
        public Tangerine(int num, int count){
            this.num=num;
            this.count=count;
        }
        
        @Override
        public int compareTo(Tangerine o){
            return o.count-this.count;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        int prev=tangerine[0];
        int count=0;
        
        ArrayList<Tangerine> tangerines=new ArrayList<>();
        for(int t:tangerine){
            if(prev==t){
                count++;
            }else{
                tangerines.add(new Tangerine(prev,count));
                prev=t;
                count=1;
            }
        }
        tangerines.add(new Tangerine(prev,count));
        
        
        Collections.sort(tangerines);
        
        for(int i=0;i<tangerines.size();i++){
            if(k>0){
                k-=tangerines.get(i).count;
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}