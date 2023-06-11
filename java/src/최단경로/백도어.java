package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백도어 {
	static class Node implements Comparable<Node>{
		int dest;
		long value;
		Node(int dest,long value){
			this.dest=dest;
			this.value=value;
		}

		@Override
		public int compareTo(Node other){
			return Long.compare(this.value,other.value);
		}
	}
	static long INF= Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		long[] isSight=new long[100001];
		long[] visited=new long[100001];
		Arrays.fill(visited,INF);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++){
			isSight[i]=Integer.parseInt(st.nextToken());
		}
		ArrayList<ArrayList<Node>> arr=new ArrayList<>();
		for(int i=0;i<N;i++){
			arr.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b,t));
			arr.get(b).add(new Node(a,t));
		}

		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(0,0));
		while(!pq.isEmpty()){
			Node node=pq.poll();
			int currentNode=node.dest;
			long currentValue=node.value;
			if(visited[currentNode]<currentValue) continue;
			for(int i=0;i<arr.get(currentNode).size();i++){
				long cost=arr.get(currentNode).get(i).value+currentValue;
				if(isSight[arr.get(currentNode).get(i).dest]==1){
					continue;
				}
				if(visited[arr.get(currentNode).get(i).dest]>cost){
					visited[arr.get(currentNode).get(i).dest]=cost;
					pq.offer(new Node(arr.get(currentNode).get(i).dest,cost));
				}
			}
		}

		if(visited[N-1]==INF){
			System.out.println(-1);
		}else {
			System.out.println(visited[N - 1]);
		}


	}
}
