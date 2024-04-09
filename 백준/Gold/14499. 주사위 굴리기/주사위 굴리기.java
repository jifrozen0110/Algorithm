

import java.io.*;
import java.util.*;

public class Main {
	static int[] target= {0,0,0,0};
	static int[] wing= {0,0};
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
	
		int[][] map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		while(K-->0) {
			int command=Integer.parseInt(st.nextToken());
			
			int nx=x+dx[command-1];
			int ny=y+dy[command-1];
			
			if(nx<0||ny<0||nx>=N||ny>=M) {continue;}
			
			if(command==1) {
				moveRight();
			}else if(command==2) {
				moveLeft();
			}else if(command==3) {
				back();
			}else if(command==4) {
				move();
			}
			if(map[nx][ny]==0) {
				map[nx][ny]=target[3];
			}else {
				target[3]=map[nx][ny];
				map[nx][ny]=0;
			}
			
//			System.out.println(Arrays.toString(target));
			x=nx;
			y=ny;
			
			System.out.println(target[1]);
			
			
		}
		
	}
	
	
	public static void moveRight() {
		int rightWing=target[1];
		int leftWing=target[3];
		target[1]=wing[0];
		target[3]=wing[1];
		
		wing[0]=leftWing;
		wing[1]=rightWing;
		
	}
	
	public static void moveLeft() {
		int leftWing=target[1];
		int rightWing=target[3];
		target[1]=wing[1];
		target[3]=wing[0];
		
		wing[0]=leftWing;
		wing[1]=rightWing;
		
	}
	
	public static void move() {
		int[] newTarget=new int[4];
		newTarget[0]=target[3];
		for(int i=1;i<4;i++) {
			newTarget[i]=target[i-1];
		}
		target=newTarget;
	}
	public static void back() {
		int[] newTarget=new int[4];
		newTarget[3]=target[0];
		for(int i=0;i<3;i++) {
			newTarget[i]=target[i+1];
		}
		target=newTarget;
	}
	
	
	
	

}
