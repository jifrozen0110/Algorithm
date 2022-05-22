package 숫자;

import java.util.Scanner;

public class 벌집 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cnt=1;
		int sum=1;
		int i;

		while(true){
			if(sum>=n) break;
			i=6*(cnt++);
			sum+=i;
		}

		System.out.println(cnt);
	}
}
