package 자료구조;
import java.util.*;
import java.io.*;

public class 최소_힙 {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++){
			int a=Integer.parseInt(br.readLine());
			if(a==0){
				if(pq.isEmpty()){
					System.out.println(0);
				}
				else{
					System.out.println(pq.poll());
				}

			}else{
				pq.offer(a);
			}
		}

	}
}
