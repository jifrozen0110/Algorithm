

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int MIN=Integer.MAX_VALUE;
	static int N,M;
	static ArrayList<CCTV> cctv=new ArrayList<>();
	static int[][][] mode= {{{0}},{{0},{1},{2},{3}},{{0,2},{1,3}},{{0,1},{1,2},{2,3},{3,0}},{{3,0,1},{0,1,2},{1,2,3},{2,3,0}},{{0,1,2,3}}};
	public static class CCTV{
		int x;
		int y;
		int type;
		public CCTV(int x,int y,int type) {
			this.x=x;
			this.y=y;
			this.type=type;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>=1&&map[i][j]<=5) {
					cctv.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		comb(0,map);
		System.out.println(MIN);
		
	}
	public static void checkScore(int[][] map) {
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					result++;
				}
			}
		}
		MIN=Math.min(MIN, result);
	}
	public static int[][] cloneMap(int[][] map) {
		int[][] newMap=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMap[i][j]=map[i][j];
			}
		}
		return newMap;
	}
	public static void comb(int depth,int[][] map) {
		if(depth==cctv.size()) {
			checkScore(map);
			return;
		}
		CCTV ct=cctv.get(depth);
		for(int i=0;i<mode[ct.type].length;i++) {
			int[][] newMap=cloneMap(map);
			for(int j=0;j<mode[ct.type][i].length;j++) {
				int dir=mode[ct.type][i][j];
				
				int nx=ct.x+dx[dir];
				int ny=ct.y+dy[dir];
				
				while(true) {
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(newMap[nx][ny]==6) break;
					newMap[nx][ny]=-1;
					nx+=dx[dir];
					ny+=dy[dir];
				}
				
			}
			comb(depth+1,newMap);
			
		}
		
		
	}

}
