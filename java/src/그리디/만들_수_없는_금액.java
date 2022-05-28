package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 만들_수_없는_금액 {
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();

		int[] arr=new int[N];

		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);

		int sum=1;
		for(int i=0;i<N;i++){
			if(sum<arr[i]) break;
			sum+=arr[i];
		}

		System.out.println(sum);

	}
}
