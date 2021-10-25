package 정렬;
import java.util.*;

public class Least_Recently_used {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int n=sc.nextInt();
		int[] arr=new int[n];
		int[] cache=new int[s];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		for(int i:arr){
			int pos=-1;
			for(int j=0;j<s;j++){
				if(i==cache[j]) pos=j;
			}
			if(pos==-1){
				for(int j=s-1;j>=1;j--){
					cache[j]=cache[j-1];
				}
			}else{
				for(int j=pos;j>=1;j--){
					cache[j]=cache[j-1];
				}
			}
			cache[0]=i;
		}

		for(int i=0;i<s;i++){
			System.out.print(cache[i]+" ");
		}






	}
}
