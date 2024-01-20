import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        int prev=tangerine[0];
        int count=0;
        
        for(int tan:tangerine){
            if(prev!=tan){
                arr.add(count);
                prev=tan;
                count=1;
            }else{
                count++;
            }
        }
        arr.add(count);
        
        Collections.sort(arr,Collections.reverseOrder());
        
        for(int i=0;i<arr.size();i++){
            if(k<=0){
                break;
            }
            k-=arr.get(i);
            answer++;
        }
        
        return answer;
    }
}