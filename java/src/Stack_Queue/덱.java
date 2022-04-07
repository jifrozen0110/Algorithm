package Stack_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 덱 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		while(n-->0){
			st=new StringTokenizer(br.readLine());

			switch(st.nextToken()){
				case "push_front":
					dq.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					dq.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "front":
					if(dq.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(dq.peekFirst());
					}
					break;
				case "size":
					System.out.println(dq.size());
					break;
				case "empty":
					if(dq.isEmpty()){
						System.out.println(1);
					}
					else{
						System.out.println(0);
					}
					break;
				case "back":
					if(dq.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(dq.peekLast());
					}
					break;
				case "pop_front":
					if(dq.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(dq.pollFirst());
					}
					break;
				case "pop_back":
					if(dq.isEmpty()){
						System.out.println(-1);
					}
					else{
						System.out.println(dq.pollLast());
					}
					break;
			}
		}
	}
}
