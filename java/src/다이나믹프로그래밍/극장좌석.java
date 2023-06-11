package 다이나믹프로그래밍;

import java.util.Scanner;

public class 극장좌석 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] vip=new int[N+1];

		for(int i=0;i<M;i++){
			vip[i]=sc.nextInt();
		}
		int[] dp=new int[N+1];

		// 1개 좌석 -> 1
		// 2개 좌석 -> 2
		// 3개 좌석 -> 3
		// 4개 좌석 -> 5
		// 5개 좌석 -> 8

		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=N;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}

		int result=1;
		int prevVip=0;
		for(int i=0;i<M;i++){
			result*=dp[vip[i]-prevVip-1];
			prevVip=vip[i];
		}
		result*=dp[N-prevVip];

		System.out.println(result);

	}
}
