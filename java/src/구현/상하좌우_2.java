package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 상하좌우_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] DIRECTIONS={"R","L","U","D"};
		int[] dx={1,-1,0,0};
		int[] dy={0,0,-1,1};

		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		ArrayList<String> arr=new ArrayList<>();

		while(st.hasMoreTokens()){
			arr.add(st.nextToken());
		}

		int x=0,y=0;
		for(String s:arr){
			for(int i=0;i<DIRECTIONS.length;i++){
				if(s.equals(DIRECTIONS[i])&&x+dx[i]>=0&&y+dy[i]>=0&&y+dy[i]<N&&x+dx[i]<N){
					x=x+dx[i];
					y=y+dy[i];
				}
			}
		}

		System.out.println((y+1)+" "+(x+1));

	}
}
