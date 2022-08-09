package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=null;

		int[][] d=new int[n][n];
		int[][] map=new int[n][n];

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()){
				d[i][j]=Integer.parseInt(st.nextToken());
				map[i][j]=d[i][j];
				j++;
			}
		}
		int upLeft=0;int up=0;
		for(int i=1;i<n;i++){
			for(int j=0;j<(i+1);j++){
				if(j==0){
					upLeft=0;
				}else{
					upLeft=d[i-1][j-1];
				}
				if(j==i){
					up=0;
				}else{
					up=d[i-1][j];
				}
				d[i][j]+=Math.max(upLeft,up);
			}
		}

		int result=0;
		for(int i=0;i<n;i++){
			result=Math.max(result,d[n-1][i]);
		}

		System.out.println(result);
	}
}
