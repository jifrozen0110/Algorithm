package 숫자;

import java.util.Scanner;

public class 숫자의_개수 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();

		String str= String.valueOf(A*B*C);

		int[] answer=new int[10];

		for(char c:str.toCharArray()){
			answer[c-'0']+=1;
		}

		for(int i=0;i<10;i++){
			System.out.println(answer[i]);
		}

	}
}
