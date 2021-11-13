package 정렬;
import java.util.*;

public class 뮤직비디오 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] time=new int[n+1];
		int end=0;
		for(int i=0;i<n;i++){
			time[i]=sc.nextInt();
			end+=time[i];
		}

		int start=time[0];

		while(start<=end){
			int sum=0;
			int cnt=0;
			int mid=(start+end)/2;
			for(int i=0;i<n;i++){
				if(sum+time[i]>mid){
					sum=0;
					cnt+=1;
				}
				sum+=time[i];
			}
			if(sum!=0) cnt+=1;
			if(cnt>m) start=mid+1;
			else end=mid-1;

		}

		System.out.print(start);

	}
}
