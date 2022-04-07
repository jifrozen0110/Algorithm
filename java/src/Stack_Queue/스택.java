package Stack_Queue;

import java.io.*;
import java.util.StringTokenizer;

public class 스택 {
	static int[] stack;
	static int size=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n=Integer.parseInt(br.readLine());
		stack=new int[n];

		while(n-->0){
			st=new StringTokenizer(br.readLine());

			switch(st.nextToken()){
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					System.out.println(pop());
					break;
				case "size":
					System.out.println(size());
					break;
				case "empty":
					System.out.println(empty());
					break;
				case "top":
					System.out.println(top());
					break;
			}
		}

	}

	public static void push(int item){
		stack[size]=item;
		size++;
	}
	public static int pop(){
		if(size==0) return -1;
		else{
			int res=stack[size-1];
			stack[size-1]=0;
			size--;
			return res;
		}
	}

	public static int size(){
		return size;
	}

	public static int empty(){
		if(size==0) return 1;
		else return 0;
	}

	public static int top(){
		if(size==0) return -1;
		else return stack[size-1];
	}
}
