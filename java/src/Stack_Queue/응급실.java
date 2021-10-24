package Stack_Queue;
import java.util.*;
public class 응급실 {
	static class Node{
		private int per;
		private int index;

		public Node(int per,int index){
			this.per=per;
			this.index=index;
		}

	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		Queue<Node> q=new LinkedList<>();

		for(int i=0;i<n;i++){
			int per=sc.nextInt();
			q.offer(new Node(per,i));
		}
		int answer=0;
		while(!q.isEmpty()){
			Node node=q.poll();
			for(Node no: q){
				if(no.per>node.per){
					q.offer(node);
					node=null;
					break;
				}
			}
			if(node!=null){
				answer++;
				if(node.index==m) break;
			}
		}

		System.out.print(answer);




	}
}
