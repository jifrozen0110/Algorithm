package 그래프_이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
	static int[] dx={0,-1,0,1};
	static int[] dy={-1,0,1,0};
	static boolean[][] visited;
	static int[][] map;
	static int N,M;
	static class Node{
		int x;
		int y;
		int hour;
		public Node(int x,int y,int hour){
			this.x=x;
			this.y=y;
			this.hour=hour;
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
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		map=new int[N][M];
		visited=new boolean[N][M];

		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int currentCnt=-1;
		int result=0;
		int lastCnt=getCheeseCount();
		while(true){
			BFS();
			for(int i=0;i<N;i++) Arrays.fill(visited[i],false);
			removeCheese();
			currentCnt=getCheeseCount();
			result++;
			if(currentCnt==0) break;
			lastCnt=currentCnt;
		}

		System.out.println(result);

			System.out.println(lastCnt);



	}

	public static void BFS(){
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(0,0,0));
		visited[0][0]=true;
		while(!q.isEmpty()){
			Node node=q.poll();
			int x=node.x;
			int y=node.y;
			int hour=node.hour;
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M){
					continue;
				}
				if(!visited[nx][ny]){
					if(map[nx][ny]==1){
						map[nx][ny]=2;
						visited[nx][ny]=true;
					}else{
						visited[nx][ny]=true;
						q.offer(new Node(nx,ny,hour+1));
					}
				}
			}
		}
	}

	public static void removeCheese(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==2){
					map[i][j]=0;
				}
			}
		}
	}
	public static int getCheeseCount(){
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==1){
					cnt++;
				}
			}
		}
		return cnt;
	}

}
