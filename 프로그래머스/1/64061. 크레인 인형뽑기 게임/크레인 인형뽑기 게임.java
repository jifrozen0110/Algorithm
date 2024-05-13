import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(int move:moves){
            for(int i=0;i<board.length;i++){
                if(board[i][move-1]!=0){
                    if(stack.isEmpty()){
                        stack.addFirst(board[i][move-1]);
                        board[i][move-1]=0;
                        break;
                    }
                    if(stack.peekFirst()==board[i][move-1]){
                        stack.removeFirst();
                        answer+=2;
                    }else{
                        stack.addFirst(board[i][move-1]);
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
            
        }
        return answer;
    }
}