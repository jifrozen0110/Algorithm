import java.util.Scanner;

public class 분산처리 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		StringBuilder sb=new StringBuilder();

		while(T-->0){
			int a=sc.nextInt();
			int b=sc.nextInt();

			int result=1;

			for(int i=0;i<b;i++){
				result=(result*a)%10;
			}

			if(result==0) sb.append(10).append("\n");
			else sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
