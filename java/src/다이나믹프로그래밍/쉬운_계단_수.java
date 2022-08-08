package 다이나믹프로그래밍;

import java.util.*;

public class 쉬운_계단_수 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[][] d=new long[N+1][10];

		for(int i=1;i<10;i++){
			d[1][i]=1;
		}

		for(int i=2;i<=N;i++){
			for(int j=0;j<10;j++){
				if(j==0){
					d[i][j]=d[i-1][1]%1000000000;
				}
				else if(j==9){
					d[i][j]=d[i-1][8]%1000000000;
				}else{
					d[i][j]=(d[i-1][j-1]+d[i-1][j+1])%1000000000;
				}
			}
		}

		long result=0;

		for(int i=0;i<10;i++){
			result+=d[N][i];
		}

		System.out.println(result%1000000000);
	}
}
