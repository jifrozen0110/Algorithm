package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이친수 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[][] d=new long[91][2];
		d[1][1]=1;
		d[2][0]=1;
		d[3][1]=1;
		d[3][0]=1;
		// d[3][0]=2;
		// d[3][1]=1;
		// d[4][0]=3;
		// d[4][1]=2;
		// d[5][0]=5;
		// d[5][1]=3;

		for(int i=3;i<=N;i++){
			d[i][0]=d[i-1][1]+d[i-1][0];
			d[i][1]=d[i-1][0];
		}

		System.out.println(d[N][0]+d[N][1]);

	}
}
