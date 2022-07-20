package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색칠 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		long W=Integer.parseInt(st.nextToken());
		long H=Integer.parseInt(st.nextToken());
		long f=Integer.parseInt(st.nextToken());
		long c=Integer.parseInt(st.nextToken());
		long x1=Integer.parseInt(st.nextToken());
		long y1=Integer.parseInt(st.nextToken());
		long x2=Integer.parseInt(st.nextToken());
		long y2=Integer.parseInt(st.nextToken());

		//세로 접은건 다 합함
		long area=(x2-x1)*(y2-y1)*(c+1);
		long totalArea=W*H;

		long result=0;

		if(f<=W/2){
			if(f<=x1){
				result=totalArea-area;
			}else{
				 result=totalArea-(area+(Math.min(f,x2)-x1)*(y2-y1)*(c+1));
			}
		}else{
			if(W<=x1+f){
				result=totalArea-area;
			}else{
				result=totalArea-(area+(Math.min(W,f+x2)-(f+x1))*(y2-y1)*(c+1));
			}
		}
		System.out.println(result);
	}
}
