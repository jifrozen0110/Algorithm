package 이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 숫자카드2 {
	static int n;
	static int[] arr;
	private static int lowerbound(int target){
		int start=0;
		int end=n-1;
		while(start<end){
			int mid=(start+end)/2;
			if(arr[mid]>=target) end=mid;
			else start=mid+1;
		}
		return end;
	}
	private static int upperbound(int target){
		int start=0;
		int end=n-1;
		while(start<end){
			int mid=(start+end)/2;
			if(arr[mid]>target) end=mid;
			else start=mid+1;
		}
		if(arr[end]==target)end++;
		return end;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());

		arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++){
			int target=Integer.parseInt(st.nextToken());

			bw.append(upperbound(target)-lowerbound(target)+" ");

		}
		bw.flush();
		bw.close();

	}
}
