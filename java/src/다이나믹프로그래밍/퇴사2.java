package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		int[] t=new int[N+1];
		int[] p=new int[N+1];
		int[] d=new int[16];

		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<N;i++){
			int time=t[i]+i;
			if(time<=N){
				d[time]=Math.max(d[time],p[i]+d[i]);
			}
			d[i+1]=Math.max(d[i+1],d[i]);
		}
		System.out.println(d[N]);
	}
}
