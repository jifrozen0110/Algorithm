class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        for(int i=0;i<board.length;i++){
            answer=Math.max(answer,board[i][0]);
        }
        
        for(int i=0;i<board[0].length;i++){
            answer=Math.max(answer,board[0][i]);
        }
        
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                if(board[i][j]>0){
                    board[i][j]=Math.min(Math.min(board[i-1][j-1],board[i][j-1]),board[i-1][j])+1;
                }
                answer=Math.max(answer,board[i][j]);
            }
        }

        return answer*answer;
    }
}