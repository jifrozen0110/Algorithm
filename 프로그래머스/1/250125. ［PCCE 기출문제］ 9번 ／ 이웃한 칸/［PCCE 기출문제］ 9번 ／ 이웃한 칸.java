import java.util.*;
class Solution {
    static int[] dx={0,1,-1,0};
    static int[] dy={1,0,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color=board[h][w];
        int n=board.length;

        for(int i=0;i<4;i++){
            int nx=h+dx[i];
            int ny=w+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n){
                continue;
            }
            if(!board[nx][ny].equals(color)){
                continue;
            }
            answer++;
        }
        
        
        return answer;
    }
}