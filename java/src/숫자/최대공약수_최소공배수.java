package 숫자;

import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());

		int d = gcd(a, b);

		System.out.println(d);
		System.out.println(a * b / d);

	}
	static int gcd(int a,int b){
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

}
