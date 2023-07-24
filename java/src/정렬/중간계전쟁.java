package 정렬;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 중간계전쟁 {
	static int[] gandal={1,2,3,3,4,10};
	static int[] sau={1,2,2,2,3,5,10};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());

		StringTokenizer st;
		for(int i=1;i<=N;i++){

			int g=0;
			int e=0;

			String good=sc.nextLine();
			st=new StringTokenizer(good);
			for(int j=0;j<6;j++){
				g+=(Integer.parseInt(st.nextToken())*gandal[j]);
			}

			String evil=sc.nextLine();
			st=new StringTokenizer(evil);
			for(int j=0;j<7;j++){
				e+=(Integer.parseInt(st.nextToken())*sau[j]);
			}

			if(g>e){
				System.out.println("Battle "+i+": Good triumphs over Evil");
			}else if(g<e){
				System.out.println("Battle "+i+": Evil eradicates all trace of Good");
			}else{
				System.out.println("Battle "+i+": No victor on this battle field");
			}

		}
	}
}
