import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> cardsQ1=new ArrayDeque<>();
        Queue<String> cardsQ2=new ArrayDeque<>();
        
        
        for(String card:cards1){
            cardsQ1.add(card);
        }
        
        for(String card:cards2){
            cardsQ2.add(card);
        }
        
        for(String target:goal){
            if(!cardsQ1.isEmpty()&&cardsQ1.peek().equals(target)){
                cardsQ1.poll();
            }else if(!cardsQ2.isEmpty()&&cardsQ2.peek().equals(target)){
                cardsQ2.poll();
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}