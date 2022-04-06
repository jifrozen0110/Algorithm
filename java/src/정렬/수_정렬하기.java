package 정렬;

import java.io.*;
import java.util.Arrays;

public class 수_정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];

		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}

	}
}
