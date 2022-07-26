package DFS_BFS;

import java.io.*;

public class 적록색약 {
	static int[] dx={0,0,1,-1};
	static int[] dy={1,-1,0,0};
	static char[][] map;
	static int[][] visited;
	static int N;
	static int result=0;
	static int result2=0;

	static void DFS(int x,int y){
		visited[x][y]=1;
		for(int i=0;i<4;i++){
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<=-1||nx>=N||ny<=-1||ny>=N) continue;
			if(visited[nx][ny]==0&&map[x][y]==map[nx][ny]){
				visited[nx][ny]=1;
				DFS(nx,ny);
			}
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());

		map=new char[N][N];
		visited=new int[N][N];

		for(int i=0;i<N;i++){
			String str=br.readLine();
			for(int j=0;j<N;j++){
				map[i][j]=str.charAt(j);
			}
		}


		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visited[i][j]==0) {
					DFS(i, j);
					result+=1;
				}
			}
		}

		visited=new int[N][N];

		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='R'){
					map[i][j]='G';
				}

			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visited[i][j]==0) {
					DFS(i, j);
					result2+=1;
				}
			}
		}

		System.out.println(result+" "+result2);

	}
}
