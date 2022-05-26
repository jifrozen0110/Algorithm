package 다이나믹프로그래밍;

import java.util.Scanner;

public class 파도반_수열 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		StringBuilder sb=new StringBuilder();

		int T=sc.nextInt();

		long[] dp=new long[101];

		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;

		while(T-->0){
			int n=sc.nextInt();

			for(int i=5;i<=n;i++){
				dp[i]=dp[i-2]+dp[i-3];
			}

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);


	}
}
