package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터_큐 {
	static class Position{
		private int value;
		private int index;

		public Position(int value,int index){
			this.value=value;
			this.index=index;
		}

		public int getValue(){
			return value;
		}

		public int getIndex(){
			return index;
		}

		public void setValue(int value){
			this.value=value;
		}

		public void setIndex(int index){
			this.index=index;
		}

	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int T=sc.nextInt();
		while(T-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			LinkedList<Position> q=new LinkedList<>();
			int cnt=0;

			for(int i=0;i<n;i++){
				int value=sc.nextInt();
				q.offer(new Position(value,i));
			}

			while(true){
				Position front=q.poll();
				boolean isMax=true;

				for(int i=0;i<q.size();i++){
					if(front.value<q.get(i).value){
						q.offer(front);
						for(int j=0;j<i;j++) {
							q.offer(q.poll());
						}
						isMax=false;
						break;
					}
				}

				if (!isMax){
					continue;
				}
				cnt++;

				if(front.index==m){
					break;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}
