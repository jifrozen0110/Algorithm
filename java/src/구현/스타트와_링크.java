package 구현;

import java.util.Scanner;
public class 스타트와_링크 {
	static int N;
	static int min=100000000;
	static int[][] list;
	static boolean[] visited;
	public static void combi(int idx,int cnt){
		if(cnt==N/2){
			diff();
			return;
		}
		for(int i=idx;i<N;i++){
			if(visited[i]==false){
				visited[i]=true;
				combi(i+1,cnt+1);
				visited[i]=false;
			}
		}
	}
	public static void diff(){

		int start=0;
		int link=0;
		for(int i=0;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				if(visited[i]==true&&visited[j]==true) start+=(list[i][j]+list[j][i]);
				if(visited[i]==false&&visited[j]==false) link+=(list[i][j]+list[j][i]);
			}
		}

		int val=Math.abs(start-link);
		if(val==0){
			min=0;
			return;
		}

		min=Math.min(val,min);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		list=new int[N][N];
		visited=new boolean[N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				list[i][j]=sc.nextInt();
			}
		}

		combi(0,0);
		System.out.println(min);


	}
}
