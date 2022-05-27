package 그리디;

import java.util.Scanner;

public class 곱하기_혹은_더하기_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		String s=sc.nextLine();

		int result=0;

		for(char c:s.toCharArray()){
			if(c=='0'||result==0){
				result+=Integer.parseInt(String.valueOf(c));
			}else{
				result*=Integer.parseInt(String.valueOf(c));
			}
		}

		System.out.println(result);
	}
}
