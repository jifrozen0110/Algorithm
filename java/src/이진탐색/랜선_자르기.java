package 이진탐색;

import java.util.Scanner;

public class 랜선_자르기 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int K=sc.nextInt();
		int N=sc.nextInt();

		long max=0;
		int[] list=new int[K+1];

		for(int i=0;i<K;i++){
			list[i]=sc.nextInt();
			max=Math.max(max,list[i]);
		}

		max++;

		long min=0;
		long mid=0;

		while(max>min){
			mid=(max+min)/2;

			long cnt=0;

			for(int i=0;i<K;i++){
				if(list[i]/mid>0) {
					cnt += (list[i] / mid);
				}
			}

			if(cnt<N){
				max=mid;
			}else{ min=mid+1;}
		}

		System.out.println(min-1);


	}
}
