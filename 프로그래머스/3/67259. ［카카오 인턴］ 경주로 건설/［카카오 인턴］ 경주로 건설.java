import java.util.*;
class Solution {
    static int[] dx={0,-1,0,1};//0 2
    static int[] dy={-1,0,1,0};//1 3
    static int INF=Integer.MAX_VALUE;
    class Node{
        int x;
        int y;
        int direction;
        int cost;
        public Node(int x,int y,int direction,int cost){
            this.x=x;
            this.y=y;
            this.direction=direction;
            this.cost=cost;
        }
    }
    public int solution(int[][] board) {
        int answer = INF;
        int n=board.length;
        int[][][] visited=new int[board.length][board.length][4];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(visited[i][j],INF);
            }
        }

        ArrayDeque<Node> q=new ArrayDeque<>();
        visited[0][0][0]=0;
        visited[0][0][1]=0;
        visited[0][0][2]=0;
        visited[0][0][3]=0;
        q.add(new Node(0,0,-1,0));

        while(!q.isEmpty()){
            Node now=q.poll();
            for(int d=0;d<4;d++){
                int nx=now.x+dx[d];
                int ny=now.y+dy[d];
                 if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

                int newCost;
                if(now.direction == -1||(now.direction-d)%2 == 0){
                    newCost = now.cost + 100;
                }else{
                    newCost = now.cost + 600;
                }

                if(nx==n-1&&ny==n-1){
                    answer=Math.min(answer,newCost);
                }

                else if (visited[nx][ny][d]==0||visited[nx][ny][d] >= newCost) {
                    visited[nx][ny][d]= newCost;
                    q.add(new Node(nx, ny, d,newCost));
                }
            }
        }

        return answer;
    }
}
