package 정렬;

import java.io.*;
import java.util.*;

public class 좌표_정렬하기 {
	static class Position implements Comparable<Position>{
		private int x;
		private int y;

		public Position(int x,int y){
			this.x=x;
			this.y=y;
		}

		@Override
		public int compareTo(Position o) {
			if(this.x==o.x){
				return Integer.compare(this.y,o.y);
			}
			return Integer.compare(this.x,o.x);
		}

		@Override
		public String toString(){
			return x+" "+y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Position> pos=new ArrayList<Position>();
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			pos.add(new Position(x,y));
		}

		Collections.sort(pos);

		for(int i=0;i<n;i++){
			System.out.println(pos.get(i).toString());
		}

	}
}
