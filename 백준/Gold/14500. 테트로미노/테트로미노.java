

import java.io.*;
import java.util.*;


public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static boolean[][] visitied;
	static int result=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		
		int M=Integer.parseInt(st.nextToken());
		
		
		int[][] map=new int[N][M];
		visitied=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visitied[i][j]=true;
				DFS(0,map[i][j],map,i,j);
				visitied[i][j]=false;
			}
		}
		
		System.out.println(result);
	}
	
	public static void DFS(int count,int sum,int[][] map,int x,int y) {
		if(count==3) {
			result=Math.max(sum, result);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) continue;
			if(visitied[nx][ny]) continue;
			
			if(count==1) {
				visitied[nx][ny]=true;
				DFS(count+1,sum+map[nx][ny],map,x,y);
				visitied[nx][ny]=false;
			}
			visitied[nx][ny]=true;
			DFS(count+1,sum+map[nx][ny],map,nx,ny);
			visitied[nx][ny]=false;
		}
		
		
	}

}
