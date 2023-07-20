package 문자열;

import java.util.Scanner;

public class 명령프롬프트 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		String[] strs=new String[N];

		for(int i=0;i<N;i++){
			strs[i]=sc.next();
		}

		char[] result=strs[0].toCharArray();


		for(int i=1;i<N;i++){
			String now=strs[i];
			for(int j=0;j<result.length;j++){
				if(now.charAt(j)==result[j]){
					result[j]=now.charAt(j);
				}else{
					result[j]='?';
				}
			}
		}

		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
		}
	}
}
