

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int N,K,minFish=Integer.MAX_VALUE;
	static int[] fishs;
	static ArrayList<int[]> arr=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		fishs=new int[N];
		
		st=new StringTokenizer(br.readLine());
		

		for(int i=0;i<N;i++) {
			fishs[i]=Integer.parseInt(st.nextToken());
			minFish=Math.min(minFish, fishs[i]);
		}
		int result=1;
		
		for(int i=0;i<N;i++) {
			if(fishs[i]==minFish) {
				fishs[i]++;
			}
		}
		
		while(true) {
		//가장 적은 어항에 물고기 +1 
		
		arr.clear();
		arr.add(fishs);
		
		if(stackFish()) break;

		result++;
		
		fishs=arr.get(0);
		for(int i=0;i<N;i++) {
			if(fishs[i]==minFish) {
				fishs[i]++;
			}
		}

		}
		
		System.out.println(result);
		
		
	}
	public static boolean check(int[] fishs) {
		int max=fishs[0];
		minFish=fishs[0];
		
		for(int i=0;i<N;i++) {
			max=Math.max(max, fishs[i]);
			minFish=Math.min(minFish, fishs[i]);
		}
		
		if(max-minFish<=K) {
			return true;
		}
		return false;
	}
	public static boolean rotateFish() {
		int start=arr.get(1).length;
		int index=arr.size();
		
		if(arr.get(0).length-start<index) return false;
		int[][] temp=new int[start][index];
		for(int j=0;j<start;j++) {
			for(int i=0;i<index;i++) {
				temp[j][i]=arr.get(i)[j];
			}
		}
		
		int[] firstFish=new int[arr.get(0).length-start];
		for(int i=start;i<arr.get(0).length;i++) {
			firstFish[i-start]=arr.get(0)[i];
		}
		
		
		arr.clear();
		
		arr.add(firstFish);
		for(int i=start-1;i>=0;i--) {
			int[] t=temp[i];
			arr.add(t);
		}
		
		for(int i=0;i<arr.size();i++) {
	}
		
		return true;
	}
	public static void divideFish() {
		int start=arr.get(0).length;
		int index=arr.size();
		int[][] map=new int[index][start];
		int[][] temp=new int[index][start];
		boolean[][] visited=new boolean[index][start];
		for(int i=0;i<arr.size();i++) {
			map[i]=arr.get(i);
		}
		

		
		
		for(int i=index-1;i>=0;i--) {
			for(int j=0;j<map[i].length;j++) {
				for(int d=0;d<2;d++) {
					int nx=i+dx[d];
					int ny=j+dy[d];
					
					if(nx<0||ny<0||nx>=index||ny>=map[nx].length) continue;
					
//					if(visited[nx][ny]) continue;
					visited[nx][ny]=true;
					
					if(Math.abs(map[i][j]-map[nx][ny])/5>0) {
//						System.out.println(map[nx][ny]+" map "+map[i][j]+" "+i+ " "+j);
						if(map[i][j]>map[nx][ny]){
							temp[nx][ny]+=Math.abs(map[i][j]-map[nx][ny])/5;
							temp[i][j]-=Math.abs(map[i][j]-map[nx][ny])/5;
//							System.out.println(temp[nx][ny]+" "+temp[i][j]);
						}else {
							temp[nx][ny]-=Math.abs(map[i][j]-map[nx][ny])/5;
							temp[i][j]+=Math.abs(map[i][j]-map[nx][ny])/5;
//							System.out.println(temp[nx][ny]+" "+temp[i][j]);
						}
					}
					
					
					
				}
			}
//			System.out.println(Arrays.toString(map[i]));
//			System.out.println(Arrays.toString(temp[i]));
		}
		
		for(int i=index-1;i>=0;i--) {
			for(int j=0;j<map[i].length;j++) {
				map[i][j]+=temp[i][j];
			}
		}
		
		arr.clear();
		
		for(int i=0;i<index;i++) {
			arr.add(map[i]);

//			System.out.println(Arrays.toString(map[i]));
			
		}
		
		
		
		
	}
	public static int[] lineFish() {
		
		int[] fishs=new int[N];
		int index=0;
		
		int[][] map=new int[arr.size()][arr.get(0).length];
		
		for(int i=0;i<arr.size();i++) {
			map[i]=arr.get(i);
		}
		
		for(int j=0;j<map[0].length;j++) {
		for(int i=0;i<map.length;i++) {
			if(j>=map[i].length) break;
//			System.out.println(index+" "+map[i][j]);
			fishs[index++]=map[i][j];
		}
			
		}
		
//		System.out.println(Arrays.toString(fishs));
		return fishs;

	}
	public static void divideHalf(int[] fishs) {
		int len=N/2;
		int[][] temp=new int[2][len];
		
		for(int i=len;i<N;i++) {
			temp[0][i-len]=fishs[i];
		}
		
		for(int i=len-1;i>=0;i--) {
			temp[1][len-i-1]=fishs[i];
		}
		
		
		arr.clear();
		for(int j=0;j<2;j++) {
			int[] t=new int[len/2];
			for(int i=len/2;i<len;i++) {
				t[i-len/2]=temp[j][i];
			}
			arr.add(t);
		}
		
		
		for(int j=1;j>=0;j--) {
			int[] t=new int[len/2];
			for(int i=len/2-1;i>=0;i--) {
				t[len/2-1-i]=temp[j][i];
			}
			arr.add(t);
		}
//		
//		for(int i=0;i<arr.size();i++) {
//			System.out.println(Arrays.toString(arr.get(i)));
//		}
		
		
		
	}
	
	public static boolean stackFish() {

		if(arr.size()==1) {
			int[] temp=arr.get(0);
			int[] firstFish=new int[N-1];
			int[] secondFish=new int[1];
			secondFish[0]=temp[0];
			for(int i=1;i<N;i++) {
				firstFish[i-1]=temp[i];
			}
			arr.set(0, firstFish);
			arr.add(secondFish);
		}
		
		
		while(rotateFish()) {
			
		}
		
		divideFish();
		
		int[] fishs=lineFish();
		
		divideHalf(fishs);
		
		divideFish();
		fishs=lineFish();
		arr.clear();
		arr.add(fishs);
		
		return check(fishs);
	}

}
