package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
		int n=Integer.parseInt(br.readLine());
		int[] d=new int[10001];
		int[] grape=new int[n+1];
		for(int i=0;i<n;i++){
			grape[i]=Integer.parseInt(br.readLine());
		}

		d[0]=grape[0];

		for(int i=1;i<n;i++){
			if(i==1){
				d[1]=grape[0]+grape[1];
				continue;
			}
			if(i==2){
				d[2]=Math.max(d[1],Math.max(grape[0]+grape[2],grape[1]+grape[2]));
				continue;
			}
			d[i]=Math.max(grape[i]+d[i-2],Math.max(d[i-1],d[i-3]+grape[i]+grape[i-1]));
		}

		System.out.println(d[n-1]);

	}
}
