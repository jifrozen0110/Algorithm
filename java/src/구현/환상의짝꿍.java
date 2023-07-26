package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 환상의짝꿍 {
	public static boolean[] primeList;
	static ArrayList<Integer> arr=new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		primeList = new boolean[2_000_001];
		primeCheck();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			long x=Long.parseLong(st.nextToken());
			long y=Long.parseLong(st.nextToken());
			long sum=x+y;

			if (sum < 4) {
				sb.append("NO").append("\n");
			} else if(sum % 2 == 0){
				sb.append("YES\n");
			} else {
				if (isCheck(sum - 2)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	static boolean isCheck(long num){
		if(num<=2_000_000) return !primeList[(int)num];
		for(int i=0;i<arr.size();i++) {
			if (num % arr.get(i) == 0) {
				return false;
			}
		}
		return true;
	}


	static void primeCheck(){
		primeList[0] = primeList[1] = true;
		for (int i = 2; i <= 2_000_000; i++) {
			if (!primeList[i]) {
				arr.add(i);
				for (int j = i * 2; j <= 2_000_000; j += i)
					primeList[j] = true;
			}
		}
	}

}

