package 정렬;
import java.util.*;

public class 좌표정렬 {
	static class Position implements Comparable<Position>{
		private int x;
		private int y;

		public Position(int x,int y){
			this.x=x;
			this.y=y;
		}

		@Override
		public int compareTo(Position other){
			if(this.x==other.x){
				return Integer.compare(this.y,other.y);
			}
			return Integer.compare(this.x,other.x);
		}

		@Override
		public String toString() {
			return this.x+" "+this.y;
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		ArrayList<Position> pos=new ArrayList<>();
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			pos.add(new Position(x,y));
		}

		Collections.sort(pos);

		for(int i=0;i<n;i++){
			System.out.println(pos.get(i).toString());
		}

	}
}
