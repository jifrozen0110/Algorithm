import java.util.*;
class Solution {

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        
        public Node(int x,int y, int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
        
    }
    public int solution(int[][] land, int height) {
        int answer = 0;
        
        PriorityQueue<Node> q=new PriorityQueue<>();
        boolean[][] visited=new boolean[land.length][land[0].length];
        

        q.add(new Node(0,0,0));

        while(!q.isEmpty()){
            Node current=q.poll();
            int x=current.x;
            int y=current.y;
            int cost=current.cost;
            if(visited[x][y]) continue;
            visited[x][y]=true;
            answer+=cost;
            for(int d=0;d<4;d++){
                int nx=x+dx[d];
                int ny=y+dy[d];
                if(nx<0||ny<0||nx>=land.length||ny>=land[0].length) continue;

                int tempCost=Math.abs(land[nx][ny]-land[x][y]);
                int newCost=tempCost<=height?0:tempCost;
                q.add(new Node(nx,ny,newCost));
            }   
        }
        
         
        return answer;
    }
}