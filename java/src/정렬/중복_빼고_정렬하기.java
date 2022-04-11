package 정렬;

import java.io.*;
import java.util.*;

public class 중복_빼고_정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		Set<Integer> set=new HashSet<Integer>();

		StringTokenizer st=new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++){
			set.add(Integer.parseInt(st.nextToken()));
		}

		List list=new ArrayList<Integer>(set);

		Collections.sort(list);

		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
}
