package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A_B {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int A=Integer.parseInt(st.nextToken());
		String B_str=st.nextToken();
		int B=Integer.parseInt(B_str);

		int result=1;

		while(true){
			if(B==A) break;
			if(B<A){
				result=-1; break;
			}
			if(B_str.charAt(B_str.length()-1)=='1'){
				B_str=B_str.substring(0,B_str.length()-1);
				B=Integer.parseInt(B_str);
			}else if(B%2==0){
				B=B/2;
				B_str=String.valueOf(B);
			}else{
				result=-1;
				break;
			}
			result++;
		}

		System.out.println(result);

	}
}
