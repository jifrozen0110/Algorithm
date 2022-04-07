package Stack_Queue;

import java.io.*;
import java.util.StringTokenizer;

public class 큐 {
	static int[] queue;
	static int front=0;
	static int end=-1;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		queue=new int[n];
		while(n-->0){
			st=new StringTokenizer(br.readLine());

			switch(st.nextToken()){
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "front":
					System.out.println(front());
					break;
				case "size":
					System.out.println(size());
					break;
				case "empty":
					System.out.println(empty());
					break;
				case "back":
					System.out.println(back());
					break;
				case "pop":
					System.out.println(pop());
					break;
			}
		}
	}
	public static int empty(){
		if(size()==0) return 1;
		else return 0;
	}
	static int size(){
		return end-front+1;
	}
	static void push(int item){
		queue[++end]=item;
	}
	static int front(){
		if(empty()==1) return -1;
		else {
			int res=queue[front];
			return res;
		}
	}
	static int pop(){
		if(empty()==1) return -1;
		else return queue[front++];
	}
	static int back(){
		if(empty()==1) return -1;
		else return queue[end];
	}
}
