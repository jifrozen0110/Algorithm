package 백트래킹;

import java.util.Scanner;

public class 계란으로계란치기 {
	static int[] w;
	static int[] p;
	static int N;
	static int cnt=0;
	static int result=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		w=new int[N];
		p=new int[N];

		for(int i=0;i<N;i++){
			int power=sc.nextInt();
			int weight=sc.nextInt();
			w[i]=weight;
			p[i]=power;
		}

		DFS(0);

		System.out.println(result);

	}
	public static void DFS(int index){
		if(index==N){
			result=Math.max(result,cnt);
			return;
		}
		if(p[index]<=0||cnt==N-1){
			DFS(index+1);
			return;
		}
		for(int i=0;i<N;i++){
			if(index==i||p[i]<=0) continue;
			p[index]-=w[i];
			p[i]-=w[index];
			if(p[index]<=0) cnt++;
			if(p[i]<=0) cnt++;
			DFS(index+1);
			if(p[index]<=0) cnt--;
			if(p[i]<=0) cnt--;
			p[index]+=w[i];
			p[i]+=w[index];
		}

	}
}
