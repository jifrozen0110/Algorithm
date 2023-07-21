package 구현;

import java.util.Scanner;

public class 사탕 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int[] sum=new int[N];
		int totalSum=0;
		for(int i=0;i<N;i++){
			sum[i]=sc.nextInt();
			totalSum+=sum[i];
		}
		totalSum=totalSum/2;

		for(int i=0;i<N;i++){
			int temp=0;
			for(int j=0;j<N;j=j+2){
				temp+=sum[(i+j)%N];
			}
			System.out.println(temp-totalSum);
		}


	}
}
