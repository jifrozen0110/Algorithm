package 구현;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수의연속합 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> primeNumber=new ArrayList<>();
		int N=sc.nextInt();

		int[] num=new int[N+1];
		num[0]=1;
		num[1]=1;

		boolean[] prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		for(int i=2; i*i<=N; i++){
			if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;
		}

		for(int i=1;i<=N;i++){
			if(!prime[i]){
				primeNumber.add(i);
			}
		}
		int cnt=0;
		int start=0;
		int end=0;
		int result=0;
		while(true){
			if(result < N){
				if(end == primeNumber.size()) break;
				result += primeNumber.get(end++);
			}else{
				result -= primeNumber.get(start++);
			}
			if(N==result) {
				cnt++;
			}
		}

		System.out.println(cnt);


	}

}
