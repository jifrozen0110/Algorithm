package DFS_BFS;
// https://www.acmicpc.net/problem/7569
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {
	static class Position{
		private int x;
		private int y;
		private int z;
		private int day;

		public Position(int x,int y,int z,int day){
			this.x=x;
			this.y=y;
			this.z=z;
			this.day=day;
		}

		public int getX(){
			return this.x;
		}

		public int getY(){
			return this.y;
		}

		public int getZ(){ return this.z;}

		public int getDay(){
			return this.day;
		}
	}
	public static int m,n,h;
	public static int[][][] arr;
	public static ArrayList<Position> pos=new ArrayList<>();
	public static int[] dx={0,-1,0,1,0,0};
	public static int[] dy={-1,0,1,0,0,0};
	public static int[] dz={0,0,0,0,-1,1};

	public static int process(ArrayList<Position> pos){
		Queue<Position> q=new LinkedList<>();
		for(int i=0;i<pos.size();i++) {
			Position p=pos.get(i);
			q.offer(new Position(p.getX(), p.getY(),p.getZ(), p.getDay()));
		}
		int d=0;
		while(!q.isEmpty()){
			Position ps=q.poll();
			int x=ps.getX();
			int y=ps.getY();
			int z=ps.getZ();
			d=ps.getDay();
			for(int i=0;i<6;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&nz>=0&&nz<h&&arr[nz][nx][ny]==0){
					q.offer(new Position(nx,ny,nz,d+1));
					arr[nz][nx][ny]=1;
				}
			}
		}
		return d;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		arr=new int[h][n][m];
		for(int k=0;k<h;k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if (arr[k][i][j] == 1)
						pos.add(new Position(i,j,k, 0));
				}
			}
		}
		int day=0;
		day=process(pos);
		boolean checkZero=false;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[k][i][j] == 0) {
						checkZero = true;
						break;
					}
				}
			}
		}

		if(checkZero){
			System.out.print(-1);
		}else{
			System.out.print(day);
		}


	}
}
