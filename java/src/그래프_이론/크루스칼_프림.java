package 그래프_이론;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 크루스칼_프림 {
	public static int[] parent=new int[10001];
	public static ArrayList<Edge> edges=new ArrayList<>();
	public static ArrayList<Vertex> list = new ArrayList<Vertex>();
	public static ArrayList<Vertex>[] vertexList;
	public static boolean[] visited;
	public static int result=0;
	static int cost=0;
	public static void main(String[] args){
		// 그래프 설정 ( 정점, 간선 , 비용)
		list.add(new Vertex(1, 2, 5));
		list.add(new Vertex(2, 3, 1));
		list.add(new Vertex(3, 6, 9));
		list.add(new Vertex(1, 4, 3));
		list.add(new Vertex(1, 3, 8));
		list.add(new Vertex(1, 5, 10));
		list.add(new Vertex(4, 5, 4));
		list.add(new Vertex(5, 6, 12));
		list.add(new Vertex(4, 6, 2));
		list.add(new Vertex(3, 4, 4));

		visited = new boolean[6+1];
		Arrays.fill(visited, false);

		vertexList = new ArrayList[6+1];
		for(int i=1;i<7;i++){
			vertexList[i] = new ArrayList<Vertex>();
		}

		// 연결리스트에 간선과 비용 설정
		for(int i=0;i<list.size();i++){
			int start = list.get(i).start;
			int end = list.get(i).end;
			int cost = list.get(i).cost;
			vertexList[start].add(new Vertex(start, end, cost));
			vertexList[end].add(new Vertex(end, start, cost));
		}

		prim(1);
		System.out.println(cost);


		edges.add(new Edge(29,1,2));
		edges.add(new Edge(75,1,5));
		edges.add(new Edge(35,2,3));
		edges.add(new Edge(34,2,6));
		edges.add(new Edge(7,3,4));
		edges.add(new Edge(23,4,6));
		edges.add(new Edge(13,4,7));
		edges.add(new Edge(53,5,6));
		edges.add(new Edge(25,6,7));
		for(int i=1;i<=7;i++){
			parent[i]=i;
		}

		Collections.sort(edges);

		for(int i=0;i<edges.size();i++){
			int cost=edges.get(i).getDist();
			int a=edges.get(i).getNodeA();
			int b=edges.get(i).getNodeB();
			if(findParent(a)!=findParent(b)){
				unionParent(a,b);
				result+=cost;
			}
		}

		System.out.println(result);

	}
	public static int findParent(int a){
		if(parent[a]==a) return a;
		return parent[a]=findParent(parent[a]);
	}
	public static void unionParent(int a,int b){
		a=findParent(a);
		b=findParent(b);
		if(a<b) parent[b]=a;
		else parent[a]=b;
	}
	static class Vertex implements Comparable<Vertex>{
		int start;
		int end;
		int cost;
		Vertex(int start,int end,int cost){
			this.start=start;
			this.end=end;
			this.cost=cost;
		}

		@Override
		public int compareTo(Vertex other){
			return Integer.compare(this.cost,other.cost);
		}
	}
	public static int prim(int startVertex){
		PriorityQueue<Vertex> pq=new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(startVertex);

		while(!q.isEmpty()){
			int start=q.poll();
			visited[start]=true;
			for(Vertex vt:vertexList[start]){
				if(!visited[vt.end]){
					pq.add(vt);
				}
			}

			while(!pq.isEmpty()){
				Vertex v=pq.poll();
				if(!visited[v.end]){
					q.add(v.end);
					visited[v.end]=true;
					cost+=v.cost;
				}
			}
		}
		return cost;
	}
	static class Edge implements Comparable<Edge>{
		private int dist;
		private int nodeA;
		private int nodeB;

		Edge(int dist,int nodeA,int nodeB){
			this.dist=dist;
			this.nodeA=nodeA;
			this.nodeB=nodeB;
		}

		public int getDist() {
			return dist;
		}

		public int getNodeA() {
			return nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}

		@Override
		public int compareTo(Edge other){
			return Integer.compare(this.dist,other.dist);
		}
	}
}
