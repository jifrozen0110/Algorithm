package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 영역_구하기 {
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static int[][] map;
	static int[][] visited;
	static int N,M,result;
	static ArrayList<Integer> arr=new ArrayList<>();
	static int DFS(int x,int y){
		result++;
		for(int i=0;i<4;i++){
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=M||ny>=N){
				continue;
			}
			if(visited[nx][ny]==0&&map[nx][ny]==0){
				visited[nx][ny]=1;
				DFS(nx,ny);
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		map=new int[M][N];
		visited=new int[M][N];

		for(int i=0;i<K;i++){
			st=new StringTokenizer(br.readLine());
			int y1=Integer.parseInt(st.nextToken());
			int x1=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			for(int j=x1;j<x2;j++){
				for(int k=y1;k<y2;k++){
					map[j][k]=1;
				}
			}
		}

		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(visited[i][j]==0&&map[i][j]==0){
					visited[i][j]=1;
					result=0;
					arr.add(DFS(i,j));
				}
			}
		}

		StringBuilder sb=new StringBuilder();

		sb.append(arr.size()+"\n");
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++){
			sb.append(arr.get(i)+" ");
		}

		System.out.println(sb);

	}
}
