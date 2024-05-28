class Solution {
    static int[] dx={-1,-1,1,1};
    static int[] dy={-1,1,1,-1};
    static int answer = 0;
    static int len;
    public int solution(int n) {
        len=n;
        int[][] board=new int[n][n];
        DFS(0,board);
        return answer;
    }
    public void DFS(int row,int[][] board){
        if(row==len){
            answer++;
            return;
        }
        for(int i=0;i<len;i++){
            if(board[row][i]==0&&isCheck(row,i,board)){
                board[row][i]=1;
                DFS(row+1,board);
                board[row][i]=0;
            }
        }
    }
    public boolean isCheck(int row,int col,int[][] board){
        for(int i=0;i<len;i++){
            if(board[i][col]==1) return false;
        }
        
        for(int d=0;d<4;d++){
            int nx=row;
            int ny=col;
            while(true){
                nx=nx+dx[d];
                ny=ny+dy[d];
                
                if(nx<0||ny<0||nx>=len||ny>=len) break;
                if(board[nx][ny]==1) return false;
                
            }
        }
        return true;
        
    }
}