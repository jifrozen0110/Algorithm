package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] d=new int[k+1];
		int[] arr=new int[n+1];
		d[0]=1;
		for(int i=1;i<=n;i++){
			arr[i]=Integer.parseInt(br.readLine());
			for(int j=arr[i];j<=k;j++){
				d[j]=d[j]+d[j-arr[i]];
			}
		}

		System.out.println(d[k]);
	}
}
