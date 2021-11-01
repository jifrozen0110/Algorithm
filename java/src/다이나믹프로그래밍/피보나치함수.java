package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 피보나치함수 {
	public static Integer[][] d=new Integer[41][2];
	public static Integer[] fibonacci(int n){
		if(d[n][0]==null||d[n][1]==null){
			d[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
			d[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
		}
		return d[n];
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb=new StringBuilder();
		d[0][0]=1;
		d[0][1]=0;
		d[1][0]=0;
		d[1][1]=1;
		int t=Integer.parseInt(br.readLine());
		 for(int i=0;i<t;i++){
		 	int num=Integer.parseInt(br.readLine());
		 	fibonacci(num);

		 	sb.append(d[num][0]+" "+d[num][1]+"\n");

		 }
		 System.out.print(sb);

	}
}
