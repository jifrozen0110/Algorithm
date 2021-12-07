package 그리디;
import java.util.*;
import java.io.*;

public class 색종이만들기 {
	public static int[][] arr;
	public static int white=0;
	public static int blue=0;
	public static void divide(int size,int x,int y){
		if(check(size,x,y)){
			if(arr[x][y]==0){
				white++;
			}else{
				blue++;
			}
			return;
		}

		int newSize=size/2;
		divide(newSize,x,y);
		divide(newSize,x+newSize,y);
		divide(newSize,x,y+newSize);
		divide(newSize,x+newSize,y+newSize);

	}
	public static boolean check(int size,int x,int y){
		int color=arr[x][y];
		for(int i=x;i<x+size;i++){
			for(int j=y;j<y+size;j++){
				if(arr[i][j]!=color){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		int n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		divide(n,0,0);

		System.out.println(white);
		System.out.println(blue);

	}
}
