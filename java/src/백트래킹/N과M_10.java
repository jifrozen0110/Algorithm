package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N과M_10 {
	static int N=0,M=0;
	static int[] num;
	static HashSet<String> hashSet=new LinkedHashSet<>();
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		num=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			num[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);


		int[] visited=new int[N];
		int[] arr=new int[N];

		DFS(0,0,arr,visited);

		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}
	public static void DFS(int cnt,int start,int[] arr,int[] visited){
		if(cnt==M){
			String str="";
			for(int i=0;i<M;i++){
				str+=arr[i]+" ";
			}
			hashSet.add(str);
			return;
		}
		for(int i=start;i<N;i++){
				arr[cnt]=num[i];
				DFS(cnt+1,i,arr,visited);
		}

	}
}
