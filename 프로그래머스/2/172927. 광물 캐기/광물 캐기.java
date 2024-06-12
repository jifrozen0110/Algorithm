import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int sum=Arrays.stream(picks).sum();
        
        int[][] score=new int[sum][3];
        for(int i=0;i<minerals.length;i+=5){
            if(i/5>=sum) break;
            for(int j=i;(j<minerals.length)&&j<i+5;j++){
                if(minerals[j].equals("diamond")){
                    score[i/5][0]+=1;
                    score[i/5][1]+=5;
                    score[i/5][2]+=25;
                }else if(minerals[j].equals("iron")){
                    score[i/5][0]+=1;
                    score[i/5][1]+=1;
                    score[i/5][2]+=5;
                }else{
                    score[i/5][0]+=1;
                    score[i/5][1]+=1;
                    score[i/5][2]+=1;
                }
            }
        }
        
        Arrays.sort(score,(o1,o2)->{
            return Integer.compare(o2[2],o1[2]);
        });
        
        int index=0;
        for(int i=0;i<score.length;i++){
            while(index<3&&picks[index]==0){
                index++;
            }
            if(index==3){
                break;
            }
            answer+=score[i][index];
            picks[index]-=1;
            
        }
        
        
        return answer;
    }
}