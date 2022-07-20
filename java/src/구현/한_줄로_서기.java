package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 한_줄로_서기 {
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));

		int N=Integer.parseInt(br.readLine());

		ArrayList<Integer> arr=new ArrayList<>();
		int[] people=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++){
			people[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=N;i>0;i--){
			arr.add(people[i-1],i);
		}

		StringBuilder sb=new StringBuilder();

		for(int i=0;i<N;i++){
			sb.append(arr.get(i)+" ");
		}

		System.out.println(sb);

	}
}
