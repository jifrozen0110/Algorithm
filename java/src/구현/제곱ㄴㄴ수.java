package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수 {
	static boolean[] numList;
	static ArrayList<Integer> arr=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		long min=Long.parseLong(st.nextToken());
		long max=Long.parseLong(st.nextToken());

		int size= (int)((max-min)+1);
		numList=new boolean[size];
		for(long i=2;Math.pow(i,2)<=max;i++){
			long square=i*i;
			long start = (min + square - 1) / square * square;
			for(long j=start;j<=max;j+=square){
				numList[(int)(j-min)]=true;
			}
		}
		int result=0;
		for(int i=0;i<size;i++){
			if(!numList[i]){
				result++;
			}
		}

		System.out.println(result);
	}
}
