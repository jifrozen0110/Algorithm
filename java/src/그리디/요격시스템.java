package 그리디;
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);

        int prevEnd=0;
        for(int i=0;i<targets.length;i++){
            if(prevEnd<=targets[i][0]){
                answer++;
                prevEnd=targets[i][1];
            }
        }
        return answer;
    }
}
