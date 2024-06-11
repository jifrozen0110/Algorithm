class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //start는 
        int start=1;
        int index=0;
        
        while(start<=n){
           if(index<stations.length&&start>=stations[index]-w&&start<=stations[index]+w){
               start=stations[index]+w+1;
               index++;
           }else{
               start=start+2*w+1;
               answer++;
           }
        }

        return answer;
    }
}