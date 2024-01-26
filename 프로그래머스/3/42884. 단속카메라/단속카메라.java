import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        
        int prev=routes[0][1];
        answer=1;
        for(int[] route:routes){
            if(prev>=route[0]){
                continue;
            }else{
                answer++;
                prev=route[1];
            }
        }
        
        return answer;
    }
}