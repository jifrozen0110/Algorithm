package 숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 홀수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int sum=0;
		int min=(int)1e9;
		for(int i=0;i<7;i++){
			int n=Integer.parseInt(br.readLine());

			if(n%2==1){
				sum+=n;
				if(min>n){
					min=n;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
			return;
		}
		sb.append(sum).append("\n").append(min);
		System.out.println(sb);

	}
}
