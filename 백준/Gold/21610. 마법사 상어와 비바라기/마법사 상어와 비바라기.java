
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx= {0,-1,-1,-1,0,1,1,1};
	static int[] dy= {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[N][N];
		int[][] cloud=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
			
		}
		
		cloud[N-1][0]=1;
		cloud[N-1][1]=1;
		cloud[N-2][1]=1;
		cloud[N-2][0]=1;
		
		while(M-->0) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			cloud=moveCloud(d,s,cloud);
			map=plusRain(map,cloud);
			map=copyRain(map,cloud);
			cloud=makeCloud(map,cloud);
		}
		
		System.out.println(calculateWater(map));
		
	}
	public static int calculateWater(int[][] map) {
		int result=0;
		int N=map.length;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				result+=map[i][j];
			}
		}
		
		return result;
	}
	public static int[][] makeCloud(int[][] map,int[][] cloud){
		int N=cloud.length;
		int[][] newCloud=new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=2&&cloud[i][j]==0) {
					map[i][j]-=2;
					newCloud[i][j]=1;
				}
			}
		}
		return newCloud;
	}
	public static int[][] copyRain(int[][] map, int[][] cloud){
		int N=cloud.length;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j]==1) {
					int rainCount=0;
					for(int d=1;d<8;d+=2) {
						int nx=i+dx[d];
						int ny=j+dy[d];
						if(nx<0||ny<0||nx>=N||ny>=N) {
							continue;
						}
						if(map[nx][ny]>0) {
							rainCount++;
						}
					}
					map[i][j]+=rainCount;
				}
			}
		}
		
		return map;
	}
	public static int[][] plusRain(int[][] map, int[][] cloud){
		int N=cloud.length;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j]==1) {
					map[i][j]+=1;
				}
			}
		}
		
		return map;
	}
	
	public static int[][] moveCloud(int d, int s,int[][] cloud) {
		int N=cloud.length;
		int[][] newCloud=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j]==1) {
					int nx=i,ny=j;
					for(int k=0;k<s;k++) {
						nx=nx+dx[d-1];
						ny=ny+dy[d-1];
						
						if(nx<0) {
							nx=N+nx;
						}
						if(nx>=N) {
							nx=nx-N;
						}
						if(ny<0) {
							ny=N+ny;
						}
						if(ny>=N) {
							ny=ny-N;
						}
					}
					newCloud[nx][ny]=1;
					
				}
			}
		}
		
		return newCloud;
	}

}

