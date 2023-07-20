package 문자열;

import java.util.Scanner;

public class 뒤집힌덧셈 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String X=String.valueOf(sc.nextInt());
		String Y=String.valueOf(sc.nextInt());

		StringBuilder sbX=new StringBuilder(X);
		StringBuilder sbY=new StringBuilder(Y);


		int x=Integer.parseInt(sbX.reverse().toString());
		int y=Integer.parseInt(sbY.reverse().toString());

		int result=x+y;

		String answer=String.valueOf(result);

		sbY=new StringBuilder(answer);

		result=Integer.parseInt(sbY.reverse().toString());

		System.out.println(result);
	}
}
