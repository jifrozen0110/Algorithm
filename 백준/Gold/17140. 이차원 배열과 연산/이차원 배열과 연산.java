

import java.util.*;
import java.io.*;
public class Main {
	static boolean isR=true;
	public static class Node implements Comparable<Node>{
		int num;
		int count;
		
		public Node(int num,int count) {
			this.num=num;
			this.count=count;
		}
		
		@Override
		public int compareTo(Node other) {
			if(other.count==this.count) return this.num-other.num;
			return this.count-other.count;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int k=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[3][3];
		
		for(int i=0;i<map.length;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<map[0].length;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		int sec=0;
		while(true) {
			if(map.length>r-1&&map[0].length>c-1&&map[r-1][c-1]==k) break;
			if(sec==100) {sec=-1;break;}
			if(isR) {
				//r
				map=rCalc(map);
				sec++;
				continue;
			}else {
				//c
				map=cCalc(map);
			}
			sec++;
		}
		
		System.out.println(sec);
	}
	public static int[][] makeRMap(ArrayList<ArrayList<Node>> nodes,int len) {
		int r=nodes.size();
		int c=len;
		if(nodes.size()>100) {
			r=100;
		}
		if(len>100) {
			c=100;
		}
		int[][] map=new int[r][c];
		
		for(int i=0;i<nodes.size();i++) {
			ArrayList<Node> node=nodes.get(i);
			for(int j=0;j<node.size();j++) {
				if(j*2>=c){break;}
				map[i][j*2]=node.get(j).num;
				if(j*2+1>=c){break;}
				map[i][j*2+1]=node.get(j).count;
			}
		}
		
		return map;
	}
	public static int[][] makeCMap(ArrayList<ArrayList<Node>> nodes,int len) {
		int r=nodes.size();
		int c=len;
		if(nodes.size()>100) {
			r=100;
		}
		if(len>100) {
			c=100;
		}
		int[][] map=new int[c][r];
		
		for(int i=0;i<nodes.size();i++) {
			ArrayList<Node> node=nodes.get(i);
			for(int j=0;j<node.size();j++) {
				map[j*2][i]=node.get(j).num;
				map[j*2+1][i]=node.get(j).count;

			}
		}
		
		return map;
	}
	public static int[][] cCalc(int[][] map) {
		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		int len=0;
		for(int i=0;i<map[0].length;i++) {
			HashMap<Integer,Integer> num=new HashMap<>();
			ArrayList<Node> node=new ArrayList<>();
			for(int j=0;j<map.length;j++) {
				if(map[j][i]==0) continue;
				num.put(map[j][i], num.getOrDefault(map[j][i], 0)+1);
			}
			for(int n:num.keySet()) {
				node.add(new Node(n,num.get(n)));
			}
			Collections.sort(node);
			len=Math.max(len, node.size()*2);
			nodes.add(node);
		}
		if(len>=nodes.size()) {
			isR=true;
		}else {
			isR=false;
		}
		return makeCMap(nodes,len);
	}
	public static int[][] rCalc(int[][] map) {
		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		int len=0;
		for(int i=0;i<map.length;i++) {
			HashMap<Integer,Integer> num=new HashMap<>();
			ArrayList<Node> node=new ArrayList<>();
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]==0) continue;
				num.put(map[i][j], num.getOrDefault(map[i][j], 0)+1);
			}
			for(int n:num.keySet()) {
				node.add(new Node(n,num.get(n)));
			}
			Collections.sort(node);
			len=Math.max(len, node.size()*2);
			nodes.add(node);
		}
		if(len>nodes.size()) {
			isR=false;
		}else {
			isR=true;
		}
		return makeRMap(nodes,len);
	}

}
