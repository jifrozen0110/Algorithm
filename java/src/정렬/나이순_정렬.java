package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 나이순_정렬 {
	static class AGE implements Comparable<AGE>{
		private int age;
		private String name;

		AGE(int age,String name){
			this.age=age;
			this.name=name;
		}

		@Override
		public int compareTo(AGE other){
			return Integer.compare(this.age, other.age);
		}

		@Override
		public String toString(){
			return this.age+" "+this.name;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine());

		ArrayList<AGE> arr=new ArrayList<>();

		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			arr.add(new AGE(Integer.parseInt(st.nextToken()),st.nextToken()));
		}

		Collections.sort(arr);

		for(int i=0;i<N;i++){
			System.out.println(arr.get(i).toString());
		}

	}
}
