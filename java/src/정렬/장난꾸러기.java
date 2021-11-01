package 정렬;
import java.util.*;
import java.io.*;
public class 장난꾸러기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		int[] tmp=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
			tmp[i]=num;
		}

		Arrays.sort(tmp);

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			if(arr[i]!=tmp[i]){
				sb.append(i+1+" ");
			}
		}

		System.out.print(sb);

	}
}
