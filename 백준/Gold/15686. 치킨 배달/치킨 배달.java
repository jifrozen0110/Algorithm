
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> chickenX=new ArrayList<>();
	static ArrayList<Integer> chickenY=new ArrayList<>();
	
	static ArrayList<Integer> houseX=new ArrayList<>();
	static ArrayList<Integer> houseY=new ArrayList<>();
	
	static int MIN=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] choiceChicken=new int[M];
		int totalChicken=0;
		
		int[][] map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chickenX.add(i);
					chickenY.add(j);
					totalChicken++;
				}
				else if(map[i][j]==1) {
					houseX.add(i);
					houseY.add(j);
				}
			}
		}
		
		DFS(0,M,0,totalChicken,choiceChicken);
		
		System.out.println(MIN);
		
		
		
	}
	
	public static void DFS(int count,int M,int index,int totalChicken,int[] choiceChicken) {
		if(count==M) {
			MIN=Math.min(MIN, calculateDistance(choiceChicken));
			return;
		}
		for(int i=index;i<totalChicken;i++) {
			choiceChicken[count]=i;
			DFS(count+1,M,i+1,totalChicken,choiceChicken);
		}
		
	}
	
	public static int calculateDistance(int[] choiceChicken) {
		int distance=0;
		for(int j=0;j<houseX.size();j++) {
			int x=houseX.get(j);
			int y=houseY.get(j);
			int minDis=Integer.MAX_VALUE;
			for(int i=0;i<choiceChicken.length;i++) {
				minDis=Math.min(minDis,Math.abs(x-chickenX.get(choiceChicken[i]))+Math.abs(y-chickenY.get(choiceChicken[i])));
			}
			distance+=minDis;
		}
		return distance;
	}
}
