package Stack_Queue;
import java.util.*;
import java.io.*;


public class 공주구하기 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();

		Queue<Integer> q=new LinkedList<>();

		for(int i=0;i<n;i++){
			q.offer(i+1);
		}
		int answer=0;
		while(!q.isEmpty()){
			for(int i=1;i<k;i++){
				q.offer(q.poll());
			}
			q.poll();
			if(q.size()==1) answer=q.poll();

		}
		System.out.print(answer);

	}
}
