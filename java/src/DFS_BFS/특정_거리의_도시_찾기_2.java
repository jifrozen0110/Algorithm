package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정_거리의_도시_찾기_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		int[] visited=new int[N+1];
		for(int i=0;i<N+1;i++){
			arr.add(new ArrayList<>());
		}

		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			arr.get(A).add(B);
		}

		StringBuilder sb=new StringBuilder();

		Queue<Integer> q=new LinkedList<>();
		q.offer(X);
		visited[X]=1;
		while(!q.isEmpty()){
			int n=q.poll();
			for(int i=0;i<arr.get(n).size();i++){
				if(visited[arr.get(n).get(i)]==0) {
					q.offer(arr.get(n).get(i));
					visited[arr.get(n).get(i)] = visited[n] + 1;
				}
			}
		}

		boolean isExist=false;
		for(int i=1;i<N+1;i++){
			if(visited[i]==K+1){
				isExist=true;
				sb.append(i+"\n");
			}
		}

		if(!isExist) sb.append(-1);

		System.out.println(sb);

	}
}
