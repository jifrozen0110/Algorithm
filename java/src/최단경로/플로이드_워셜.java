package 최단경로;
import java.util.*;
public class 플로이드_워셜 {
	public static void main(String[] args){
		int[][] graph=new int[5][5];
		int INF=(int)1e9;
		int n=4;
		for(int i=0;i<=n;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j) {
					graph[i][j] = 0;
				}
			}
		}

		graph[1][2]=4;
		graph[1][4]=6;
		graph[2][1]=3;
		graph[2][3]=7;
		graph[3][1]=5;
		graph[3][4]=4;
		graph[4][3]=2;

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int k=1;k<=n;k++){
					graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
				}
			}
		}

		for(int a=1;a<=n;a++){
			for(int b=1;b<=n;b++){
				if(graph[a][b]==INF){
					System.out.print("INF");
				}
				else{
					System.out.print(graph[a][b]+ " ");
				}
			}
			System.out.println();
		}


	}
}
