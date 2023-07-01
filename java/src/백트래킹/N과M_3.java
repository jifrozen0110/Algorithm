package 백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N과M_3 {
	static int N=0,M=0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		int[] visited=new int[N];
		int[] arr=new int[M];

		DFS(0,arr);
		bw.flush();

		bw.close();
		br.close();


	}
	public static void DFS(int cnt,int[] arr) throws IOException {
		if(cnt==M){
			for(int i=0;i<M;i++){
				bw.write(Integer.toString(arr[i])+" ");
			}
			bw.newLine();
			return;
		}
		for(int i=0;i<N;i++){
			arr[cnt]=i+1;
			DFS(cnt+1,arr);

		}

	}
}
