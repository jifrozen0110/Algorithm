

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		int[][] map=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			map[x-1][y-1]=2;
		}
		
		int L=Integer.parseInt(br.readLine());
		
		HashMap<Integer,String> pos=new HashMap<>();
		
		for(int l=0;l<L;l++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			String y=st.nextToken();
			pos.put(x, y);
		}
		
		int sec=1;
		int d=1;
		int headX=0;
		int headY=0;
		int tailX=0;
		int tailY=0;
		Queue<Integer> savePos=new LinkedList<>();
		
		map[0][0]=1;
		
		while(true) {
			int nx=headX+dx[d];
			int ny=headY+dy[d];
			if(nx<0||ny<0||nx>=N||ny>=N) {
				break;
			}
			if(map[nx][ny]==1) {
				break;
			}
			savePos.add(d);
			if(map[nx][ny]==2) {
				map[nx][ny]=1;
				headX=nx;
				headY=ny;
			}else {
				map[tailX][tailY]=0;
				int dir=savePos.poll();
				tailX=tailX+dx[dir];
				tailY=tailY+dy[dir];
				map[nx][ny]=1;
				headX=nx;
				headY=ny;
			}
			if(pos.containsKey(sec)) {
				String direction=pos.get(sec);
				if(direction.equals("L")) {
					d=(d==0)?3:d-1;
				}else {
					d=(d==3)?0:d+1;
				}
			}
			sec++;
		}
		
		
		System.out.println(sec);
		
		
		
	}
	

}
