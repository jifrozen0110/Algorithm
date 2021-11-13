package 정렬;
import java.util.*;

public class 이분검색 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);
		int start=0;
		int end=n;
		int index=0;
		while(start<=end){
			int mid=(start+end)/2;
			if(arr[mid]==m){
				index=mid;
				break;
			}
			else if(arr[mid]>m){
				end=mid-1;
			}
			else start=mid+1;
		}

		System.out.print(index+1);

	}
}
