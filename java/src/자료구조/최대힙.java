package 자료구조;
import java.io.*;
import java.util.*;

public class 최대힙 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		while(n-->0){
			int num=Integer.parseInt(br.readLine());
			if(num==0){
				if(!pq.isEmpty()){
					sb.append(pq.poll()+"\n");
				}else{
					sb.append(0+"\n");
				}
			}else{
				pq.offer(num);
			}
		}
		System.out.println(sb);

	}
}
