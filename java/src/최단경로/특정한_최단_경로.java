package 최단경로;
import java.util.*;
import java.io.*;

public class 특정한_최단_경로 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int INF=(int)1e9;

		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());

		int[][] arr=new int[n+1][n+1];

		for(int i=0;i<=n;i++){
			Arrays.fill(arr[i],INF);
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j){
					arr[i][j]=0;
				}
			}
		}


		for(int i=0;i<e;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			arr[a][b]=c;
			arr[b][a]=c;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int k=1;k<=n;k++){
					arr[j][k]=Math.min(arr[j][i]+arr[i][k],arr[j][k]);
				}
			}
		}

		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int len1=INF;
		int len2=INF;
		if(arr[1][a]<INF&&arr[a][b]<INF&&arr[b][n]<INF) {
			len1 = arr[1][a] + arr[a][b] + arr[b][n];
		}
		if(arr[1][b]<INF&&arr[b][a]<INF&&arr[a][n]<INF) {
			len2=arr[1][b]+arr[b][a]+arr[a][n];
		}

		if(len1>=INF&&len2>=INF) System.out.print(-1);
		else System.out.print(Math.min(len1,len2));

	}
}
