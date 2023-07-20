package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 농구경기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();

		String[] strs=new String[N];

		for(int i=0;i<N;i++){
			strs[i]=sc.next();
		}

		Arrays.sort(strs);
		char first=strs[0].charAt(0);
		int cnt=1;
		String result="";
		for(int i=1;i<N;i++){

			String now=strs[i];

			if(now.charAt(0)==first){
				cnt++;
			}else{
				cnt=1;
				first=now.charAt(0);
			}
			if(cnt==5){
				result+=first;
			}

		}

		if(result.length()==0){
			System.out.println("PREDAJA");
		}else {
			System.out.println(result);
		}
	}
}
