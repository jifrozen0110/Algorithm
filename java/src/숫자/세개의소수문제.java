package 숫자;

import java.util.Scanner;

public class 세개의소수문제 {
	static boolean[] primeArray=new boolean[1001];
	public static void makePrimeArr(){
		primeArray[0]=true;
		primeArray[1]=true;

		for(int i=2;i<Math.sqrt(1001);i++){
			if(!primeArray[i]){
				for(int j=i+i;j<1001;j+=i){
					primeArray[j]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		makePrimeArr();
		int T=sc.nextInt();
		while(T-->0){
			int k=sc.nextInt();

			boolean isAnswer=false;
			for(int i=2;i<k;i++){
				if(primeArray[i]) continue;
				for(int j=2;j<k;j++){
					if(primeArray[j]) continue;
					for(int m=2;m<k;m++){
						if(primeArray[m]) continue;
						if(!primeArray[i]&&!primeArray[j]&&!primeArray[m]){
							if(i+j+m==k){
								System.out.println(i+" "+" "+j+" "+m);
								isAnswer=true;
								break;
							}
						}
					}
					if(isAnswer) break;
				}
				if(isAnswer) break;
			}

			if(!isAnswer)
				System.out.println(0);

		}
	}
}
