package 구현;

import java.util.Scanner;

public class 더하기_사이클 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int num=sc.nextInt();
		int first=0;
		int cnt=0;
		int s=num;
		while(true){
			first=s%10;
			s=(first+s/10)%10+first*10;
			cnt++;
			if(s==num) break;
		}

		System.out.println(cnt);

	}
}
