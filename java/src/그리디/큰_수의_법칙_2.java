package 그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 큰_수의_법칙_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();

		int[] arr=new int[N];

		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);

		int big=arr[N-1]*K+arr[N-2];

		System.out.println(M/(K+1)*big+M%(K+1)*arr[N-1]);
	}
}
