import java.util.*;
class Solution {
    static ArrayList<String> answer=new ArrayList<>();
    static int n;
    public String[] solution(String[][] tickets) {
        n=tickets.length;
        boolean[] visited=new boolean[n];
        
        DFS("ICN",tickets,visited,"ICN");
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    public static void DFS(String start,String[][] map,boolean[] visited,String word){
        if (word.split(" ").length==n+1){
            answer.add(word);
            return;
        }
        for(int i=0;i<map.length;i++){
            if (map[i][0].equals(start)&&!visited[i]){
                visited[i]=true;
                DFS(map[i][1],map,visited,word+" "+map[i][1]);
                visited[i]=false;
            }
        }
    }
}