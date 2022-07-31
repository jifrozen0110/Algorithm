package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의_부모_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] visited=new int[N+1];

		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

		for(int i=0;i<N+1;i++){
			arr.add(new ArrayList<>());
		}

		for(int i=0;i<N-1;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr.get(x).add(y);
			arr.get(y).add(x);
		}

		Queue<Integer> q=new LinkedList<>();
		q.offer(1);
		visited[1]=1;
		while(!q.isEmpty()){
			int i=q.poll();
			for(int j=0;j<arr.get(i).size();j++){
				if(visited[arr.get(i).get(j)]==0){
					visited[arr.get(i).get(j)]=i;
					q.offer(arr.get(i).get(j));
				}
			}
		}

		for(int i=2;i<N+1;i++){
			System.out.println(visited[i]);
		}


	}
}
