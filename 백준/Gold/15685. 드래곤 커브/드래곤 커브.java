

import java.io.*;
import java.util.*;

public class Main {
	static int[] dy= {0,-1,0,1};
	static int[] dx= {1,0,-1,0};
	static int[][] map=new int[101][101];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		
		
		while(N-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			moveDragon(x,y,d,g);
		}
		int result=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1&&map[i+1][j]==1&&map[i][j+1]==1&&map[i+1][j+1]==1) result++;
			}
		}
		
		System.out.println(result);
		
	}
	public static void moveDragon(int x,int y,int d,int g){
		ArrayList<Integer> directions=new ArrayList<>();
		directions.add(d);
		map[y][x]=1;
		int nx = x + dx[d];
        int ny = y + dy[d];
        map[ny][nx] = 1;

		for(int i=1;i<=g;i++) {
			
			for(int j=directions.size()-1;j>=0;j--) {
				int newDir = (directions.get(j) + 1) % 4;
				nx=nx+dx[newDir];
				ny=ny+dy[newDir];
				directions.add(newDir);

				map[ny][nx]=1;
			
			}
		}
	}
	
}
