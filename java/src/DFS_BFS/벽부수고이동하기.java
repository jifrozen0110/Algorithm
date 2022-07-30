package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};
	static int N,M,result=-1;
	static int[][] map;
	static class Node{
		private int x;
		private int y;
		private int cnt;
		Node(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		map=new int[N][M];
		int[][][] visited=new int[N][M][2];

		for(int i=0;i<N;i++){
			String str=br.readLine();
			for(int j=0;j<M;j++){
				map[i][j]=str.charAt(j)-'0';
			}
		}

		Queue<Node> q=new LinkedList<>();
		q.offer(new Node(0,0,1));
		visited[0][0][1]=1;
		while(!q.isEmpty()){
			Node n=q.poll();
			int x=n.x;
			int y=n.y;
			int cnt=n.cnt;
			if(x==N-1&&y==M-1){
				result=visited[x][y][cnt];
				break;
			};
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M){
					continue;
				}
				if(map[nx][ny]==1&&cnt==1){
					visited[nx][ny][0]=visited[x][y][cnt]+1;
					q.offer(new Node(nx,ny,0));
				}
				if(map[nx][ny]==0&&visited[nx][ny][cnt]==0){
					visited[nx][ny][cnt]=visited[x][y][cnt]+1;
					q.offer(new Node(nx,ny,cnt));
				}
			}
		}

		System.out.println(result);


	}
}
