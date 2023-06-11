package 구현;

import java.util.Scanner;

public class 피보나치는지겨워 {
	static int MOD=1000000007;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();

		long[] fibonacci=new long[51];
		fibonacci[0]=1;
		fibonacci[1]=1;

		for(int i=2;i<51;i++){
			fibonacci[i]=fibonacci[i-2]%MOD+fibonacci[i-1]%MOD+1;
		}

		System.out.println(fibonacci[n]%MOD);

	}
}
