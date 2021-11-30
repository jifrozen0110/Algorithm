package 자료구조;

import java.util.*;
import java.io.*;


public class 듣보잡 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		HashSet<String> hs=new HashSet<>();
		ArrayList<String> arr2=new ArrayList<>();

		for(int i=0;i<n;i++){
			hs.add(br.readLine());
		}

		for(int i=0;i<m;i++){
			String s=br.readLine();
			if(hs.contains(s)){
				arr2.add(s);
			}
		}

		Collections.sort(arr2);

		System.out.println(arr2.size());
		for(String str:arr2){
			System.out.println(str);
		}



	}
}
