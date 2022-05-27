package 그리디;

import java.util.Scanner;

public class 문자열_뒤집기_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		String str=sc.nextLine();

		int changeOne=0;
		int changeZero=0;

		char now=str.charAt(0);

		if(now=='0') changeOne++;
		else changeZero++;

		for(char c:str.toCharArray()){
			if(c=='0'&&now!=c){
				changeOne++;
				now=c;
			}else if(c=='1'&&now!=c){
				changeZero++;
				now=c;
			}

		}

		System.out.println(Math.min(changeOne,changeZero));
	}
}
