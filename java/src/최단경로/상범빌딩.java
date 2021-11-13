package 최단경로;
import java.util.*;
import java.io.*;

public class 상범빌딩 {
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int z;
		private int dist;

		public Node(int x,int y, int z,int dist){
			this.x=x;
			this.y=y;
			this.z=z;
			this.dist=dist;
		}

		public int getX(){
			return this.x;
		}

		public int getY(){
			return this.y;
		}

		public int getZ(){
			return this.z;
		}

		public int getDist(){
			return dist;
		}

		@Override
		public int compareTo(Node other){
			if(this.dist<other.dist){
				return -1;
			}
			return 1;
		}

	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int l=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());

		Character[][][] graph=new Character[l][r][c];
		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();



		for(int i=l-1;i>=0;i--){
			for(int j=0;j<r;j++){
				String str=br.readLine();
				for(int k=0;k<c;k++){
					graph[i][j][k]=str.charAt(k);
					// nodes.add
				}
			}
			br.readLine();
		}



	}
}
