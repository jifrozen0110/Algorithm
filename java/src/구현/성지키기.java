package 구현;

import java.util.Scanner;

public class 성지키기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();


		char[][] map=new char[N][M];
		for(int i=0;i<N;i++){
			String str=sc.next();
			for(int j=0;j<M;j++){
				map[i][j]=str.charAt(j);
			}
		}

		int rowCnt=0;
		int colCnt=0;

		for(int i=0;i<N;i++){
			boolean colCheck=false;
			for(int j=0;j<M;j++){
				if(map[i][j]=='X'){
					colCheck=true;
				}
			}
			if(!colCheck){
				colCnt++;
			}
		}

		for(int i=0;i<M;i++){
			boolean rowCheck=false;
			for(int j=0;j<N;j++){
				if(map[j][i]=='X'){
					rowCheck=true;
				}
			}
			if(!rowCheck){
				rowCnt++;
			}
		}

		System.out.println(Math.max(rowCnt,colCnt));
	}
}
