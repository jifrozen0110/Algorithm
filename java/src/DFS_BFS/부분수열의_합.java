package DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의_합 {
	static int[] arr;
	static int S;
	static int N;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());

		arr=new int[N];

		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		DFS(0,0);

		if(S==0){
			count--;
		}
		System.out.println(count);


	}

	static void DFS(int start,int sum){
		if(start==N) {
			if (sum == S) {
				count++;
			}
			return;
		}
		DFS(start+1,sum+arr[start]);
		DFS(start+1,sum);

	}

}
