package 그리디;

import java.util.Scanner;

public class 숫자_카드_게임2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int M=sc.nextInt();

		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			int min=Integer.MAX_VALUE;
			for(int j=0;j<M;j++){
				min=Math.min(min,sc.nextInt());
			}
			max=Math.max(max,min);
		}

		System.out.println(max);
	}
}
