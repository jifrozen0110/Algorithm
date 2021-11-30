package 구현;

import java.util.*;

public class 팩토리얼_0의_개수 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int answer=0;

		if(n>=5){
			while(n>=5){
				answer+=n/5;
				n=n/5;
			}
		}

		System.out.print(answer);

	}
}
