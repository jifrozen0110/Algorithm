package 최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송 {
	static class Node implements Comparable<Node>{
		int dest;
		int value;
		public Node(int dest,int value){
			this.dest=dest;
			this.value=value;
		}

		@Override
		public int compareTo(Node n){
			return Integer.compare(this.value,n.value);
		}
	}
	static int INF=(int)1e9;
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		int[] visited=new int[N+1];
		Arrays.fill(visited,INF);
		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		for(int i=0;i<=N;i++){
			nodes.add(new ArrayList<>());
		}

		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			nodes.get(A).add(new Node(B,C));
			nodes.get(B).add(new Node(A,C));
		}

		visited[1]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(1,0));

		while(!pq.isEmpty()){
			Node currentNode=pq.poll();
			int currentDest= currentNode.dest;
			int currentValue= currentNode.value;

			if(visited[currentDest]<currentValue) continue;

			for(int i=0;i<nodes.get(currentDest).size();i++){
				int cost=nodes.get(currentDest).get(i).value+currentValue;
				if(cost<visited[nodes.get(currentDest).get(i).dest]){
					visited[nodes.get(currentDest).get(i).dest]=cost;
					pq.offer(new Node(nodes.get(currentDest).get(i).dest,cost));
				}
			}
		}

		System.out.println(visited[N]);


	}
}
