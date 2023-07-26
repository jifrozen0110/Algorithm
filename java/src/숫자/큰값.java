package 숫자;

import java.util.Scanner;

public class 큰값 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (x == 0 && y == 0) {
				break;
			}

			if(x<=y){
				System.out.println("No");
			}else
				System.out.println("Yes");
		}
	}
}
