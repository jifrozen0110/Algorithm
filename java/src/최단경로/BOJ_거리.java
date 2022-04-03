package 최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		char[] street=br.readLine().toCharArray();
		int MAX=(int)1e9;
		int[] dp=new int[n];
		Arrays.fill(dp,MAX);

		dp[0]=0;

		for(int i=0;i<n-1;i++){
			int now=i;
			char boj=street[now];
			if(boj=='B'){
				for(int j=i+1;j<n;j++){
					int next=j;
					char nextBoj=street[next];
					if(nextBoj=='O'){
						dp[next]=Math.min(dp[next],dp[now]+(next-now)*(next-now));
					}
				}
			}
			else if(boj=='O'){
				for(int j=i+1;j<n;j++){
					int next=j;
					char nextBoj=street[next];
					if(nextBoj=='J'){
						dp[next]=Math.min(dp[next],dp[now]+(next-now)*(next-now));
					}
				}
			}else{
				for(int j=i+1;j<n;j++){
					int next=j;
					char nextBoj=street[next];
					if(nextBoj=='B'){
						dp[next]=Math.min(dp[next],dp[now]+(next-now)*(next-now));
					}
				}
			}

		}
		if(dp[n-1]==MAX){
			System.out.println(-1);
		}else{
			System.out.println(dp[n-1]);
		}

	}
}
