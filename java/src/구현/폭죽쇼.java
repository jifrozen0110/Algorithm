package 구현;

import java.util.HashSet;
import java.util.Scanner;

public class 폭죽쇼 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int C=sc.nextInt();
		int[] time=new int[C+1];
		for(int i=0;i<N;i++){
			int num=sc.nextInt();
			for(int j=num;j<=C;j=j+num){
				time[j]=1;
			}
		}

		int sum=0;
		for(int i=1;i<=C;i++){
			sum+=time[i];
		}

		System.out.println(sum);
	}
}
