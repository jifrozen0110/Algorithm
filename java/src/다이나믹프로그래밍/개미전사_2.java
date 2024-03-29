package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미전사_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());

		int[] d=new int[101];
		int[] arr=new int[N];

		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		d[0]=arr[0];
		d[1]=Math.max(arr[0],arr[1]);
		for(int i=2;i<N;i++){
			d[i]=Math.max(d[i-1],d[i-2]+arr[i]);
		}

		System.out.println(d[N-1]);


	}
}
