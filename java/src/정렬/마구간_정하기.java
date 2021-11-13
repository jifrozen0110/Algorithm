package 정렬;
import java.util.*;

public class 마구간_정하기 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int c=sc.nextInt();
		int[] x=new int[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
		}

		Arrays.sort(x);

		int start=1;
		int end=x[n-1];
		int result=0;

		while(start<=end){
			int mid=(start+end)/2;
			int value=x[0];
			int cnt=1;
			for(int i=1;i<n;i++){
				if(x[i]-value>=mid){
					value=x[i];
					cnt+=1;
				}
			}
			if(cnt>=c) {
				result=mid;
				start=mid+1;
			}
			else end=mid-1;
		}

		System.out.print(result);


	}
}
