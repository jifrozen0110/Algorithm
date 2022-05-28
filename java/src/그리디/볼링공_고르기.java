package 그리디;

import java.util.Scanner;

public class 볼링공_고르기 {
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int M=sc.nextInt();

		int[] arr=new int[M+1];

		for(int i=0;i<N;i++){
			arr[sc.nextInt()]+=1;
		}

		int result=0;
		for(int i=1;i<=M;i++){
			N=N-arr[i];
			result+=arr[i]*N;
		}

		System.out.println(result);
	}
}
