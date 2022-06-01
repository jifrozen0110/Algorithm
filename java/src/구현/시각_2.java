package 구현;

import java.util.Scanner;

public class 시각_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();

		int cnt=0;

		for(int i=0;i<=N;i++){
			for(int j=0;j<60;j++){
				for(int k=0;k<60;k++){
					if(i%10==3||j%10==3||j/10==3||k%10==3||k/10==3){
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
