package 구현;

import java.util.Scanner;

public class 윷놀이 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();

		for(int n=0;n<3;n++){
			int cnt1=0;
			for(int i=0;i<4;i++){
				if(sc.nextInt()==1){
					cnt1++;
				}
			}

			switch(cnt1){
				case 0:
					sb.append("D").append("\n"); break;
				case 1:
					sb.append("C").append("\n"); break;
				case 2:
					sb.append("B").append("\n"); break;
				case 3:
					sb.append("A").append("\n"); break;
				case 4:
					sb.append("E").append("\n"); break;
			}
		}

		System.out.println(sb);
	}
}
