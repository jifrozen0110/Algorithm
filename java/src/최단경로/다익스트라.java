package 최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라 {
	static class Node implements Comparable<Node>{
		private int index;
		private int distance;

		Node(int index,int distance){
			this.index=index;
			this.distance=distance;
		}

		public int getIndex(){
			return this.index;
		}

		public int getDistance(){
			return this.distance;
		}

		@Override
		public int compareTo(Node other){
			if(this.distance<other.distance){
				return -1;
			}
			return 1;
		}
	}

	public static final int INF=(int)1e9;
	public static int n,m,start;
	public static int[] d=new int[100001];
	public static ArrayList<ArrayList<Node>> graph=new ArrayList<>();

	public static void dijkstra(int start){
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(start,0));
		d[start]=0;
		while(!pq.isEmpty()){
			Node node=pq.poll();
			int dist=node.getDistance();
			int now=node.getIndex();
			if(d[now]<dist) continue;
			for(int i=0;i<graph.get(now).size();i++){
				int cost=d[now]+graph.get(now).get(i).getDistance();
				if(cost<d[graph.get(now).get(i).getIndex()]){
					d[graph.get(now).get(i).getIndex()]=cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(),cost));
				}
			}
		}
	}


	public static void main(String[] args){
		n=6;
		for(int i=0;i<=n;i++){
			graph.add(new ArrayList<Node>());
		}

		Arrays.fill(d,INF);
		graph.get(1).add(new Node(2,2));
		graph.get(1).add(new Node(3,5));
		graph.get(1).add(new Node(4,1));
		graph.get(2).add(new Node(3,3));
		graph.get(2).add(new Node(4,2));
		graph.get(3).add(new Node(2,3));
		graph.get(3).add(new Node(6,5));
		graph.get(4).add(new Node(3,3));
		graph.get(4).add(new Node(5,1));
		graph.get(4).add(new Node(5,1));
		graph.get(5).add(new Node(3,1));
		graph.get(5).add(new Node(6,2));

		dijkstra(1);
		for(int i=1;i<=n;i++){
			if(d[i]==INF){
				System.out.println("INF");
			}
			else{
				System.out.println(d[i]);
			}
		}

	}
}
