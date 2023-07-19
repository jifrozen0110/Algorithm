package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 소문난칠공주 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[] map=new char[25];
	static boolean[] visited=new boolean[25];
	static int result=0;
	static int[] selected;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		selected=new int[7];

		for(int i=0;i<5;i++){
			String str=br.readLine();
			for(int j=0;j<5;j++){
				map[i*5+j]=str.charAt(j);
			}
		}

		DFS(0,0,0);

		System.out.println(result);



	}
	public static boolean isAdjacent(){
		boolean[] advisitied=new boolean[25];
		Queue<Integer> q=new LinkedList<>();
		q.add(selected[0]);
		int cnt=1;
		while(!q.isEmpty()){
			int now=q.poll();
			advisitied[now]=true;
			for (int j = 0; j < 4; j++) {
				int nx = (now/5) + dx[j];
				int ny = now%5 + dy[j];
				if (nx >= 0 &&ny>=0&& nx<5&&ny < 5 && !advisitied[nx*5+ny]&&visited[nx*5+ny]) {
					advisitied[nx*5+ny] = true;
					cnt++;
					q.add(nx*5+ny);
				}
			}
		}
		if(cnt==7) return true;
		return false;
	}
	public static void DFS(int start,int cnt,int s){
		if(cnt==7){
			if(s>=4){
				if(isAdjacent()){
					result++;
				}
				return;
			}
			return;
		}

		for(int i=start;i<25;i++){
			visited[i]=true;
			selected[cnt]=i;
			if(map[i]=='S') DFS(i+1,cnt+1,s+1);
			else DFS(i+1,cnt+1,s);
			visited[i]=false;
		}


	}
}
