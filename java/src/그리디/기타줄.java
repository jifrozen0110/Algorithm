package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 기타줄 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int M=sc.nextInt();

		int[] pakage=new int[M];
		int[] piece=new int[M];

		for(int i=0;i<M;i++){
			pakage[i]=sc.nextInt();
			piece[i]=sc.nextInt();
		}

		Arrays.sort(pakage);
		Arrays.sort(piece);

		int p=N/6;
		int r=N%6;
		int result=0;

		if(pakage[0]<piece[0]*6){
			result+=pakage[0]*p;
		}else{
			result+=piece[0]*6*p;
		}

		if(pakage[0]<piece[0]*r){
			result+=pakage[0];
		}else{
			result+=piece[0]*r;
		}

		System.out.println(result);

	}
}
