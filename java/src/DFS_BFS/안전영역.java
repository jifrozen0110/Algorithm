package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안전영역 {
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static int N;
	static int[][] map;
	static int[][] visited;
	static void cut(){
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j]=0;
				map[i][j]-=1;
			}
		}

	}
	static int DFS(int x,int y){
		visited[x][y]=1;
		for(int i=0;i<4;i++){
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<N&&ny<N){
				if(map[nx][ny]>0&&visited[nx][ny]==0){
					visited[nx][ny]=1;
					DFS(nx,ny);

				}
			}
		}
		return 1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new int[N][N];

		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int answer = 0;

		for (int k = 0; k < max + 1; k++) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0&&map[i][j]>0) {
						result+=DFS(i,j);
					}
				}
			}
			cut();
			answer = Math.max(answer, result);
		}

		System.out.println(answer);

	}
}
