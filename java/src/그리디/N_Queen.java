package 그리디;

import java.util.Scanner;

public class N_Queen {
	public static int N;
	public static int[] arr;
	public static int cnt=0;
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();

		arr=new int[N];
		nQueen(0);

		System.out.println(cnt);


	}
	public static void nQueen(int depth){
		if(depth==N){
			cnt++;
			return;
		}
		// 같은 열에 놓일 수 없음
		for(int i=0;i<N;i++){
			arr[depth]=i;
			if(possibility(depth)){
				nQueen(depth+1);
			}
		}
	}

	private static boolean possibility(int depth) {
		// 행
		for(int i=0;i<depth;i++){
			// 같은 행에 높이면 안됨
			if(arr[depth]==arr[i]) return false;
			// 대각선이 높이면 안됨
			else if(Math.abs(arr[depth]-arr[i])==Math.abs(depth-i)) return false;

		}
		return true;
	}
}
