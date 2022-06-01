package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 오와_육의_차이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		String A=st.nextToken();
		String B=st.nextToken();



		String A_min=A.replace('6','5');
		String A_max=A.replace('5','6');

		String B_min=B.replace('6','5');
		String B_max=B.replace('5','6');


		int minValue=Integer.parseInt(A_min)+Integer.parseInt(B_min);
		int maxValue=Integer.parseInt(A_max)+Integer.parseInt(B_max);

		System.out.println(minValue+" "+maxValue);

	}
}
