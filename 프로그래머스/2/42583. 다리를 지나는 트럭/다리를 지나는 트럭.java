import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<truck_weights.length;i++){
            int num=truck_weights[i];
            while(true){

                if(q.size()==bridge_length){
                    sum-=q.poll();
                }

                if(sum+num<=weight){
                    sum=sum+num;
                    q.offer(num);
                    answer++;
                    break;
                }else{
                    answer++;
                    q.offer(0);
                }
            }
        }

        answer+=bridge_length;
        return answer;
    }
}