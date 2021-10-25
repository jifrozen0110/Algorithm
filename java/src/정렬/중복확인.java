package 정렬;
import java.util.*;

public class 중복확인 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] arr=new int[n];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i]==arr[j]){
					System.out.print("D");
					return;
				}
			}
		}
		System.out.print("U");
	}
}
