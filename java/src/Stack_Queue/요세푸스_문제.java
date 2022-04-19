package Stack_Queue;

import java.io.*;
import java.util.*;


public class 요세푸스_문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		Queue<Integer> q=new LinkedList<>();

		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++){
			q.offer(i);
		}

		sb.append("<");

		while(q.size()!=1){
			for(int i=0;i<k-1;i++){
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
		}

		sb.append(q.poll()+">");
		System.out.println(sb);


	}
}
