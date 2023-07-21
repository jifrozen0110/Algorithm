package 구현;

import java.util.Scanner;

public class 이상한곱셈 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String A=String.valueOf(sc.nextBigInteger());
		String B=String.valueOf(sc.nextBigInteger());

		if(A.equals("0")||B.equals("0")){
			System.out.println(0);
			return;
		}

		int[] Aarr=new int[A.length()];
		int[] Barr=new int[B.length()];


		for(int i=0;i<A.length();i++){
			Aarr[i]=A.charAt(i)-'0';
		}

		for(int i=0;i<B.length();i++){
			Barr[i]=B.charAt(i)-'0';
		}
		long sum=0;
		for(int i=0;i<A.length();i++){
			for(int j=0;j<B.length();j++){
				sum+=Aarr[i]*Barr[j];
			}
		}

		System.out.println(sum);

	}
}
