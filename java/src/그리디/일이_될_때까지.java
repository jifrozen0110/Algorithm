package 그리디;

import java.util.Scanner;

public class 일이_될_때까지 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int K=sc.nextInt();

		int cnt=0;

		while(N>=K){
			while(N%K!=0){
				N-=1;
				cnt++;
			}
			N=N/K;
			cnt++;
		}

		while(N>1){
			N=N-1;
			cnt++;
		}

		System.out.println(cnt);


	}
}
