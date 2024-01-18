import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        Arrays.sort(jobs,(a,b)->{
            return a[0]-b[0];
        });
        
        int sec=0,index=0,count=0;
        
        while(count<jobs.length){
            while(index<jobs.length&&sec>=jobs[index][0]){
                pq.add(jobs[index]);
                index++;
            }
            if(pq.isEmpty()){
                sec=jobs[index][0];
            }else{
                int[] job=pq.poll();
                answer+=sec-job[0]+job[1];
                sec+=job[1];
                count++;
            }
            
        }
        
        
        return answer/jobs.length;
    }
}