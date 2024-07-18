import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int index=0;
        for(int sc:score){
            if(pq.size()<k){
                pq.offer(sc);
            }else{
                if(pq.peek()<sc){
                    pq.poll();
                    pq.offer(sc);
                }
            }
            answer[index++]=pq.peek();
        }
        return answer;
    }
}