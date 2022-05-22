package 다이나믹프로그래밍;

import java.util.Scanner;

public class 가장_긴_증가하는_부분_수열 {
	static int n;
	static int[] dp;
	static int[] list;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		dp=new int[n];
		list=new int[n];

		for(int i=0;i<n;i++){
			list[i]=sc.nextInt();
		}

		int result=Integer.MIN_VALUE;


		for(int i=0;i<n;i++){
			LIS(i);
		}
		for(int i=0;i<n;i++){
			result=Math.max(dp[i],result);
		}

		System.out.println(result);


	}
	public static int LIS(int n){
		if(dp[n] == 0) {
			dp[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (list[i] < list[n]) {
					dp[n] = Math.max(dp[n], LIS(i) + 1);
				}
			}
		}

		return dp[n];

	}

}
