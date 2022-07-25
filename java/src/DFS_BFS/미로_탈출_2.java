package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탈출_2 {
	static int[] dx={-1,1,0,0};
	static int[] dy={0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		int[][] map=new int[N][M];

		for(int i=0;i<N;i++){
			String s=br.readLine();
			for(int j=0;j<M;j++){
				map[i][j]=s.charAt(j)-'0';
			}
		}

		Queue<Node> q=new LinkedList<>();
		q.offer(new Node(0,0));
		while(!q.isEmpty()){
			Node node=q.poll();
			for(int i=0;i<4;i++){
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=M){
					continue;
				}
				if(map[nx][ny]==0) continue;
				if(map[nx][ny]==1){
					map[nx][ny]=map[node.x][node.y]+1;
					q.offer(new Node(nx,ny));
				}
			}
		}

		System.out.println(map[N-1][M-1]);
	}
	static class Node{
		private int x;
		private int y;

		public Node(){
		}

		public Node(int x,int y){
			this.x=x;
			this.y=y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
}
