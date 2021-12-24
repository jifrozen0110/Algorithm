package 정렬;
import java.util.*;

public class 좌표_압축 {
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int[] arr=new int[n];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		int[] arrClone=arr.clone();
		Arrays.sort(arrClone);

		HashMap<Integer,Integer> hashMap=new HashMap<>();

		int idx=0;
		for(int i=0;i<n;i++){
			if(!hashMap.containsKey(arrClone[i])){
				hashMap.put(arrClone[i],idx++);
			}
		}

		StringBuilder sb=new StringBuilder();

		for(int i:arr){
			sb.append(hashMap.get(i)+" ");
		}

		System.out.println(sb.toString());

	}
}
