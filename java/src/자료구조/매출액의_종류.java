package 자료구조;
import java.util.*;
import java.io.*;

public class 매출액의_종류 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		int[] arr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		HashMap<Integer,Integer> map=new HashMap<>();
		int lt=0;
		StringBuilder sb=new StringBuilder();
		for(int rt=0;rt<n;rt++){
			map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
			if(rt-lt+1==k){
				sb.append(map.size()+ " ");
				map.put(arr[lt],map.get(arr[lt])-1);
				if(map.get(arr[lt])==0){
					map.remove(arr[lt]);
				}
				lt++;
			}
		}

		System.out.print(sb.toString());


	}
}
