import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[] memo=new int[friends.length];
        int[][] arrange=new int[friends.length][friends.length];
        
        HashMap<String,Integer> score=new HashMap<>();
        HashMap<String,Integer> index=new HashMap<>();
        
        int i=0;
        for(String friend:friends){
            score.put(friend,0);
            index.put(friend,i);
            i++;
        }
        
        for(String gift:gifts){
            String[] g=gift.split(" ");
            score.put(g[0],score.get(g[0])+1);
            score.put(g[1],score.get(g[1])-1);
            arrange[index.get(g[0])][index.get(g[1])]+=1;
        }
        

        for(int g=0;g<friends.length;g++){
            for(int r=g+1;r<friends.length;r++){
                if(g==r) continue;
                if(arrange[g][r]!=0||arrange[r][g]!=0){
                    if(arrange[g][r]>arrange[r][g]){
                        memo[g]+=1;
                    continue;
                    }else if(arrange[g][r]<arrange[r][g]){
                        memo[r]+=1;
                    continue;
                    }
                }
                if(score.get(friends[g])>score.get(friends[r])){
                    memo[g]+=1;
                }else if(score.get(friends[g])<score.get(friends[r])){
                    memo[r]+=1;
                }
            }
        }
        
        
        
        return Arrays.stream(memo).max().getAsInt();
    }
}