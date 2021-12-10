package DFS_BFS;
import java.io.*;
import java.util.*;

public class 치즈 {
	public static int n,m;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static boolean[][] visited;
	public static int[][] map;
	static ArrayList<Node> cheeseList;
	static int cheeseCnt=0;
	public static class Node{
		private int x;
		private int y;

		public Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		cheeseList=new ArrayList<>();

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				int a=Integer.parseInt(st.nextToken());
				map[i][j]=a;
				if(a==1){
					cheeseList.add(new Node(i,j));
					cheeseCnt+=1;
				}
			}
		}

		int time=0;


		while(cheeseCnt!=0){
			time++;
			visited=new boolean[n][m];
			bfs();
			melting();
		}

		System.out.println(time);

	}
	public static void melting(){
		for(int i=0;i<cheeseList.size();i++){
			int x=cheeseList.get(i).x;
			int y=cheeseList.get(i).y;
			int cnt=0;

			for(int j=0;j<4;j++){
				int nx=x+dx[j];
				int ny=y+dy[j];
				if(map[nx][ny]==2){
					cnt++;
				}
			}

			if(cnt>=2){
				map[x][y]=0;
				cheeseCnt--;
				cheeseList.remove(i);
				i--;
			}
		}
	}
	public static void bfs(){
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(0,0));
		visited[0][0]=true;
		map[0][0]=2;
		while(!q.isEmpty()){
			Node node=q.poll();
			int x=node.x;
			int y=node.y;

			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if (visited[nx][ny] || map[nx][ny] == 1) continue;
				map[nx][ny]=2;
				q.add(new Node(nx,ny));
				visited[nx][ny]=true;
			}
		}

	}

}
