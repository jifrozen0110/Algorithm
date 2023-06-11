package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 소가정보섬에올라온이유 {
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());

		int[] cows=new int[N];
		int[] quality=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			cows[i]=Integer.parseInt(st.nextToken());
		}


		int sum=0;
		for(int i=0;i<cows.length;i++){
			quality[i]=cows[i]*cows[(i+1)%N]*cows[(i+2)%N]*cows[(i+3)%N];
			sum+=quality[i];
		}

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++){
			int q=Integer.parseInt(st.nextToken());
			sum-=quality[q-1];
			quality[q-1]*=-1;
			sum+=quality[q-1]*-2;
			sum-=quality[(q-2+N)%N];
			quality[(q-2+N)%N]*=-1;
			sum+=quality[(q-2+N)%N];
			sum-=quality[(q-3+N)%N];
			quality[(q-3+N)%N]*=-1;
			sum+=quality[(q-3+N)%N];
			sum-=quality[(q-4+N)%N];
			quality[(q-4+N)%N]*=-1;
			sum+=quality[(q-4+N)%N];
			sb.append(sum+"\n");
		}


		System.out.println(sb.toString());
	}
}
