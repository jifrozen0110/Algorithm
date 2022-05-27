package 그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 모험가_길드_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		Integer[] arr=new Integer[N];

		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);

		int cnt=1;
		int result=0;

		for(int i=0;i<N;i++){
			if(arr[i]>cnt){
				cnt++;
			}
			else{
				result++;
				cnt=1;
			}
		}

		System.out.println(result);


	}
}
