class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static String[] keys={"down","right","up","left"};
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int row=board[0]/2;
        int col=board[1]/2;

        int x=row,y=col;
        
        for(String key:keyinput){
            for(int i=0;i<4;i++){
                if(keys[i].equals(key)){
                    int nx=x+dy[i];
                    int ny=y+dx[i];
                    if(nx<0||ny<0||nx>=board[0]||ny>=board[1]){
                        continue;
                    }
                    x=nx;
                    y=ny;
                }
            }
        }
        
        answer[0]=x-row;
        answer[1]=y-col;
        
        return answer;
    }
}