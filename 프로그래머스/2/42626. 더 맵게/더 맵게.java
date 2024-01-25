import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int scovileFood:scoville){
            pq.offer(scovileFood);
        }
        
        while(!pq.isEmpty()){
            int a=pq.peek();
            if(a<K){
                a=pq.poll();
                if(pq.isEmpty()){
                     break;
                }
                int b=pq.poll();
                pq.offer(a+(b*2));
                answer++;
            }else{
                break;
            }
        }
        
        if(pq.isEmpty()){
            return -1;
        }
        if(pq.poll()<K){
            return -1;
        }
        return answer;
    }
}