package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_7 {
	static int N=0,M=0;
	static int[] num;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		num=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			num[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int[] visited=new int[N];
		int[] arr=new int[N];

		DFS(0,0,arr,visited);

		System.out.println(sb.toString());

	}
	public static void DFS(int cnt,int start,int[] arr,int[] visited){
		if(cnt==M){
			for(int i=0;i<M;i++){
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++){
			if(visited[i]==0||!(arr[cnt-1]==num[i])){
				visited[i]=1;
				arr[cnt]=num[i];
				DFS(cnt+1,i,arr,visited);
				visited[i]=0;
			}
		}

	}
}
