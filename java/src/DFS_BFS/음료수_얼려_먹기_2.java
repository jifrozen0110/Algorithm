package DFS_BFS;

import java.util.Scanner;

public class 음료수_얼려_먹기_2 {
	public static int[][] arr={
		{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}
	};
	public static boolean DFS(int x,int y){
		if(x<=-1||x>=4||y<=-1||y>=5){
			return false;
		}
		if(arr[x][y]==0){
			arr[x][y]=1;
			DFS(x-1,y);
			DFS(x,y-1);
			DFS(x+1,y);
			DFS(x,y+1);
			return true;
		}
		return false;
	}

	public static void main(String[] args){
		int result=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				if(DFS(i,j)){
					result+=1;
				}
			}
		}
		System.out.println(result);
	}

}
