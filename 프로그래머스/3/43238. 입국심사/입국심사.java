import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long start=1;
        long end=(long)times[times.length-1]*n;
        long mid=0;
        
        while(start<=end){
            mid=(start+end)/2;
            long count=0;
            for(int i=0;i<times.length;i++){
                count+=mid/times[i];
            }
            if(count<n){
                start=mid+1;
            }else{
                answer=mid;
                end=mid-1;
            }
        }
        return answer;
    }
}