package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 문자열_재정렬_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));

		String s=br.readLine();
		ArrayList<Character> ca=new ArrayList<>();
		int val=0;

		for(char c:s.toCharArray()){
			if(Character.isLetter(c)){
				ca.add(c);
			}else{
				val+=c-'0';
			}
		}

		Collections.sort(ca);
		StringBuilder sb=new StringBuilder();

		for(char c:ca){
			sb.append(c);
		}

		System.out.println(sb.toString()+val);
	}
}
