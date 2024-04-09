
import java.io.*;
import java.util.*;

public class Main {
	static int N,L,R;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static boolean[][] visited;
	static int[][] map;
	static boolean isTrue=true;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result=0;
		
		while(isTrue) {
			visited=new boolean[N][N];
			isTrue=false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						BFS(i,j);
					}
				}
			}
			
			if(isTrue) {
				result++;
			}
		}
		
		System.out.println(result);
		
		
	}
	public static void BFS(int x,int y) {
		Queue<int[]> q=new LinkedList<>();
		ArrayList<int[]> nodes=new ArrayList<>();
		q.add(new int[] {x,y});
		int sum=map[x][y];
		visited[x][y]=true;
		nodes.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] pos=q.poll();
			int score=map[pos[0]][pos[1]];
			for(int d=0;d<4;d++) {
				int nx=pos[0]+dx[d];
				int ny=pos[1]+dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(visited[nx][ny]) continue;
				if(Math.abs(map[nx][ny]-score)>=L&&Math.abs(map[nx][ny]-score)<=R) {
					isTrue=true;
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
					sum+=map[nx][ny];
					nodes.add(new int[] {nx,ny});
				}
			}
		}
		
		int avg=sum/nodes.size();
		for(int i=0;i<nodes.size();i++) {
			int[] pos=nodes.get(i);
			map[pos[0]][pos[1]]=avg;
		}
		
		
	}

}
