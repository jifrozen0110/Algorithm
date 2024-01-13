import java.util.*;
class Solution {
    static class Node{
        int index;
        int distance;
        public Node(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<ArrayList<Node>> arr=new ArrayList<>();
        
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0;i<road.length;i++){
            int a=road[i][0];
            int b=road[i][1];
            int c=road[i][2];
            arr.get(a).add(new Node(b,c));
            arr.get(b).add(new Node(a,c));
        }
        
        int[] visited=new int[N+1];
        
        Arrays.fill(visited,Integer.MAX_VALUE);
        
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(1,0));
        visited[1]=0;
        
        while(!q.isEmpty()){
            Node node=q.poll();
            int index=node.index;
            int dis=node.distance;
            if(visited[index]<dis) continue;
            for(int i=0;i<arr.get(index).size();i++){
                Node newNode=arr.get(index).get(i);
                int newDist=newNode.distance+visited[index];
                if(newDist<visited[newNode.index]){
                    visited[newNode.index]=newDist;
                    q.offer(new Node(newNode.index,newDist));
                }
            }
        }
        
        for(int i=1;i<N+1;i++){
            if(visited[i]<=K){
                answer++;
            }
        }
        
        return answer;
    }
}