package 백트래킹;

import java.util.Scanner;

public class N과M_2 {
	static int N=0,M=0;
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		M=sc.nextInt();

		int[] visited=new int[N+1];
		int[] arr=new int[M];
		DFS(0,1,visited,arr);

		
	}
	public static void DFS(int cnt,int start,int[] visited,int[] arr){

		if(cnt==M){
			for(int i=0;i<M;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++){

			if(visited[i]==0){
				visited[i]=1;
				arr[cnt]=i;
				DFS(cnt+1,arr[cnt]+1,visited,arr);
				visited[i]=0;
			}

		}

	}
}
