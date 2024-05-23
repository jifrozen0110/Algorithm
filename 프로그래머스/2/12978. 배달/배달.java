import java.util.*;
class Solution {
    static int INF=Integer.MAX_VALUE;
    class Node implements Comparable<Node>{
        int index;
        int distance;
        
        public Node(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
        
        @Override
        public int compareTo(Node o){
            return this.distance-o.distance;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> arr=new ArrayList<>();
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int[] r:road){
            arr.get(r[0]).add(new Node(r[1],r[2]));
            arr.get(r[1]).add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int[] visited=new int[N+1];
        Arrays.fill(visited,INF);
        visited[1]=0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int index=now.index;
            for(int i=0;i<arr.get(index).size();i++){
                Node n=arr.get(index).get(i);
                int v=now.distance+n.distance;
                if(visited[n.index]>=v){
                    visited[n.index]=v;
                    pq.add(new Node(n.index,v));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(visited[i]<=K){
                answer++;
            }
        }

        

        return answer;
    }
}