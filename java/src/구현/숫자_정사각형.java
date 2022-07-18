package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_정사각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		int MIN= Math.min(m,n);
		int[][] map=new int[n][m];

		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<m;j++){
				map[i][j]=s.charAt(j)-'0';
			}
		}

		int result=0;
		int area=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<MIN;k++){
					if(j+k<m&&i+k<n) {
						if (map[i][j] == map[i][j + k] && map[i][j] == map[i + k][j] && map[i][j] == map[i + k][j + k]) {
							area=(k+1)*(k+1);
							result = Math.max(area,result);
						}
					}
				}
			}
		}

		System.out.println(result);
		
	}
}
