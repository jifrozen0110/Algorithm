package 구현;

import java.util.Scanner;

public class 왕실의_나이트_2 {
	public static void main(String[] args){
		int[] dx={2,2,-2,-2,1,1,-1,-1};
		int[] dy={-1,1,-1,1,2,-2,2,-2};

		Scanner sc=new Scanner(System.in);
		String direction=sc.next();

		int x=direction.charAt(0)-'a';
		int y=direction.charAt(1)-'0'-1;

		int result=0;

		for(int i=0;i<8;i++){
			if(x+dx[i]>=0&&y+dy[i]>=0&&x+dx[i]<8&&y+dy[i]<8){
				result++;
			}
		}

		System.out.println(result);

	}
}
