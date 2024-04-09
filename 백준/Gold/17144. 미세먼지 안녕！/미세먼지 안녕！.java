

import java.io.*;
import java.util.*;
public class Main {
	static int R,C;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[] cleanPos=new int[2];
	static int[][] clean= {{1,0,3,2},{1,2,3,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[R][C];
		int index=0;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					cleanPos[index]=i;
					index++;
				}
			}
		}
		
		while(T-->0) {
			map=spreadDust(map);
			map=cleanDust(map);
		}
		
		System.out.println(calculateDust(map));
		
		
		
	}
	
	public static long calculateDust(int[][] map) {
		long result=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) result+=map[i][j];
			}
		}
		return result;
	}
	
	public static int[][] cleanDust(int[][] map) {
		int[][] newMap=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				newMap[i][j]=map[i][j];
			}
		}
		for(int i=0;i<2;i++) {
			int x=cleanPos[i];
			int y=1;
			newMap[x][y]=0;
			for(int d=0;d<4;d++) {
				while(true) {
					int nx=x+dx[clean[i][d]];
					int ny=y+dy[clean[i][d]];
					if(nx<0||ny<0||nx>=R||ny>=C) break;
					if(map[nx][ny]==-1) break;
					newMap[nx][ny]=map[x][y];
					x=nx;
					y=ny;
				}
				
			}
			
		}
		return newMap;
		
	}
	public static int[][] spreadDust(int[][] map) {
		int[][] newMap=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					int score=map[i][j]/5;
					int count=0;
					for(int d=0;d<4;d++) {
						int nx=i+dx[d];
						int ny=j+dy[d];
						if(nx<0||ny<0||nx>=R||ny>=C) continue;
						if(map[nx][ny]==-1) continue;
						count++;
						newMap[nx][ny]+=score;
					}
					newMap[i][j]+=(-score*count);
				}
			}
		}
		return plusDust(map,newMap);
		
	}
	
	public static int[][] plusDust(int[][] map, int[][] newMap){
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=newMap[i][j];
			}
		}
		return map;
	}

}


