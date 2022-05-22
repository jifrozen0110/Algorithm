package 다이나믹프로그래밍;

import java.util.Scanner;

public class 연속합 {
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] dp=new int[n+1];
		int[] cost=new int[n+1];

		for(int i=1;i<n+1;i++){
			cost[i]=sc.nextInt();
		}

		dp[1]=cost[1];
		for(int i=2;i<n+1;i++){
			dp[i]=Math.max(dp[i-1]+cost[i],cost[i]);
		}

		int max=Integer.MIN_VALUE;
		for(int i=1;i<n+1;i++){
			if(dp[i]>max){
				max=dp[i];
			}
		}

		System.out.println(max);


	}
}
