
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx={0,1,0,-1};
	public static int[] dy={1,0,-1,0};
	public static int result=0;
	public static int[][] temp;
	public static int[][] map;
	public static int N,M;

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		map=new int[N][M];
		temp=new int[N][M];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		DFS(0);

		System.out.println(result);



	}
	public static void DFS(int count){
		if(count==3){
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					temp[i][j]=map[i][j];
				}
			}
			for(int i=0;i<N;i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			result=Math.max(result,getScore(temp));
			return;
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==0){
					map[i][j]=1;
					DFS(count+1);
					map[i][j]=0;
				}
			}
		}

	}
	public static void virus(int i,int j){
		for (int k = 0; k < 4; k++) {
			int nx =i+dx[k];
			int ny=j+dy[k];
			if(nx<0||ny<0||nx>=N||ny>=M){
				continue;
			}
			if(temp[nx][ny]==0){
				temp[nx][ny]=2;
				virus(nx,ny);
			}
		}

	}
	public static int getScore(int[][] map){
		int score=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++) {
				if(map[i][j]==0){
					score++;
				}
			}
		}
		return score;
	}
}
