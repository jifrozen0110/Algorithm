package Stack_Queue;

import java.io.*;
import java.util.*;

public class 스택수열{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());

		Stack<Integer> stack=new Stack<>();
		int start=0;

		while(n-->0){
			int i=Integer.parseInt(br.readLine());
			if(start<i) {
				for(int j=start+1;j<=i;j++){
					stack.add(j);
					sb.append("+"+"\n");
				}
				start=i;
			}
			else if(stack.peek()!=i){
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-"+"\n");

		}
		System.out.println(sb);

	}
}
