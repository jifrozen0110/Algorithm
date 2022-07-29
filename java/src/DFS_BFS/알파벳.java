package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알파벳 {
	static class Node{
		private int x;
		private int y;
		private int index;

		Node(int x,int y,int index){
			this.x=x;
			this.y=y;
			this.index=index;
		}
	}
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static int R,C,result=0;
	static char[][] map;
	static ArrayList<Character> alphabet;
	static void DFS(Node node){
		int x=node.x;
		int y=node.y;
		int index=node.index;
		for(int i=0;i<4;i++){
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=R||ny>=C){
				continue;
			}
			if(!alphabet.contains(map[nx][ny])){
				alphabet.add(map[nx][ny]);
				DFS(new Node(nx,ny,index+1));
				result=Math.max(result,index+1);
				alphabet.remove(index);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());

		map=new char[R][C];

		alphabet=new ArrayList<>();

		for(int i=0;i<R;i++){
			String str=br.readLine();
			for(int j=0;j<C;j++){
				map[i][j]=str.charAt(j);
			}
		}
		alphabet.add(map[0][0]);
		result=1;
		DFS(new Node(0,0,result));

		System.out.println(result);

	}
}
