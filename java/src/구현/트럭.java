package 구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트럭 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int w=sc.nextInt();
		int L=sc.nextInt();

		Queue<Integer> q=new LinkedList<>();

		for(int i=0;i<n;i++){
			q.offer(sc.nextInt());
		}

		int sec=0;
		int weight=0;
		int num=0;
		Queue<Integer> bridge=new LinkedList<>();
		while (!q.isEmpty()){
			sec++;
			if(bridge.size()==w){
				weight-=bridge.poll();
			}
			if(q.peek()+weight<=L){
				num=q.poll();
				weight+=num;
				bridge.offer(num);
			}else{
				bridge.offer(0);
			}
		}

		sec+=w;

		System.out.println(sec);
	}
}
