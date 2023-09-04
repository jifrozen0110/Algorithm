
import java.util.*;

public class 보석도둑 {
	//https://www.acmicpc.net/problem/1202
	//보석의 크기가 1,000,000
	//최대 값 구하는 문제 -> 정렬, 우선순위큐 사용
	static class Jewelry implements Comparable<Jewelry>{
		int weight;
		int value;
		public Jewelry(int weight,int value){
			this.weight=weight;
			this.value=value;
		}

		@Override
		public int compareTo(Jewelry other){
			if(this.weight==other.weight){
				return other.value-this.value;
			}
			return this.weight-other.weight;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int K=sc.nextInt();

		List<Jewelry> jewelries=new ArrayList<Jewelry>();
		for(int i=0;i<N;i++){
			int m=sc.nextInt();
			int v=sc.nextInt();
			jewelries.add(new Jewelry(m,v));
		}

		Collections.sort(jewelries);

		int[] bags=new int[K];
		for(int i=0;i<K;i++){
			bags[i]=sc.nextInt();
		}

		Arrays.sort(bags);

		long answer=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		int j=0;
		for(int i=0;i<K;i++){
			while(N>j&&jewelries.get(j).weight<=bags[i]){
				pq.offer(jewelries.get(j++).value);
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		System.out.println(answer);

	}
}
