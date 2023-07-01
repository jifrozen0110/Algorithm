package 백트래킹;

import java.util.Scanner;

public class N과M_1 {
	static int N=0,M=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		M=sc.nextInt();

		int[] visited=new int[N];
		int[] arr=new int[N];

		DFS(0,arr,visited);

	}
	public static void DFS(int cnt,int[] arr,int[] visited){
		if(cnt==M){
			for(int i=0;i<M;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<N;i++){
			if(visited[i]==0){
				visited[i]=1;
				arr[cnt]=i+1;
				DFS(cnt+1,arr,visited);
				visited[i]=0;
			}
		}

	}
}
