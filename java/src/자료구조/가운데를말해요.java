package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.PriorityQueue;

public class 가운데를말해요 {
	public static void main(String[] args) throws IOException {
		// 시간 제한이 0.1초 -> 특정 알고리즘 / 자료구조 필요함
		// 중간값을 구하는 문제
		// 우선순위큐 2개를 활용하여 중간값 구하기 -> 중간값은 정려된 그룹을 반으로 나눠서 작은그룹에서 가장 큰 값이고 큰 그룹에서는 가장 작은값임을 이용함

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap=new PriorityQueue<>((o1,o2) -> o1-o2);
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1,o2)->o2-o1);

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++){
			int num=Integer.parseInt(br.readLine());
			if(maxHeap.size()==minHeap.size()) maxHeap.offer(num);
			else minHeap.offer(num);
			if(!maxHeap.isEmpty()&&!minHeap.isEmpty()) {
				int max = maxHeap.peek();
				int min = minHeap.peek();
				if (max > min) {
					maxHeap.poll();
					minHeap.poll();
					maxHeap.offer(min);
					minHeap.offer(max);
				}
			}
			sb.append(maxHeap.peek()+"\n");
		}

		System.out.println(sb.toString());

	}
}
