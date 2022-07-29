package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경쟁적_전염_2 {
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int sec;
		private int index;
		Node(int x,int y,int sec,int index){
			this.x=x;
			this.y=y;
			this.sec=sec;
			this.index=index;
		}

		@Override
		public int compareTo(Node other){
			if(this.index>other.index){
				return 1;
			}else return -1;
		}
	}
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		int[][] map=new int[N][N];

		Queue<Node> q=new LinkedList<>();

		ArrayList<Node> min=new ArrayList<>();

		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>0){
					min.add(new Node(i,j,0,map[i][j]));
				}
			}
		}

		Collections.sort(min);

		for(int i=0;i<min.size();i++){
			q.offer(min.get(i));
		}

		st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());

		while(q.peek()!=null&&q.peek().sec<S){
			Node node=q.poll();
			int x=node.x;
			int y=node.y;
			int sec=node.sec;
			int index=node.index;
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N){
					continue;
				}
				if(map[nx][ny]==0){
					map[nx][ny]=index;
					q.offer(new Node(nx,ny,sec+1,index));
				}
			}
		}

		System.out.println(map[X-1][Y-1]);



	}
}
