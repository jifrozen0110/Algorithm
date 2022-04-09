package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보물 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		Integer[] arr1=new Integer[n];
		Integer[] arr2=new Integer[n];

		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int j=0;j<n;j++){
			arr1[j]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr1);

		st=new StringTokenizer(br.readLine());
		for(int j=0;j<n;j++){
			arr2[j]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr2, Collections.reverseOrder());
		int sum=0;

		for(int j=0;j<n;j++){
			sum+=arr1[j]*arr2[j];
		}

		System.out.println(sum);

	}
}
