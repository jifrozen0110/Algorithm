import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len=players.length;
        String[] answer = new String[len];
  
        HashMap<Integer,String> rank=new HashMap<>();
        HashMap<String,Integer> name=new HashMap<>();
        
        int idx=1;
        for(String player:players){
            rank.put(idx,player);
            name.put(player,idx++);
        }
        
        for(String calling:callings){
            int r=name.get(calling);
            String next=rank.get(r-1);
            rank.put(r-1,calling);
            name.put(calling,r-1);
            rank.put(r,next);
            name.put(next,r);
        }
        
        return rank.values().stream().toArray(String[]::new);
    }
}