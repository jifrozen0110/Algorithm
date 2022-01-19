package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 곱하기_혹은_더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str=br.readLine();

		int answer=0;
		for(char c:str.toCharArray()){
			if(c-'0'==0||answer==0){
				answer+=c-'0';
			}else{
				answer*=(c-'0');
			}
		}

		System.out.println("answer = " + answer);
	}
}
