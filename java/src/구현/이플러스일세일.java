package 구현;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 이플러스일세일 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Integer[] goods=new Integer[N];
		int sum=0;
		for(int i=0;i<N;i++){
			goods[i]=sc.nextInt();
			sum+=goods[i];
		}
		int discount=0;
		Arrays.sort(goods,Collections.reverseOrder());

		for(int i=0;i<N;i++){
			if((i+1)%3==0){
				discount+=goods[i];
			}
		}

		System.out.println(sum-discount);


	}
}
