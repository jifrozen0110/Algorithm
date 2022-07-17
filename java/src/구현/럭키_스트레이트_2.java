package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 럭키_스트레이트_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int a=0,b=0;
		for(int i=0;i<s.length()/2;i++){
			a += s.charAt(i) - '0';
			b+=s.charAt(s.length()-i-1)-'0';
		}

		if(a==b){
			System.out.println("LUCKY");
		}else{
			System.out.println("READY");
		}
	}
}
