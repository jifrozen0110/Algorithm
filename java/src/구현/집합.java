package 구현;
import java.io.*;
import java.util.*;

public class 집합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		boolean[] b=new boolean[21];
		while(n-->0){
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			int num=0;
			switch(s){
				case "add":
					num=Integer.parseInt(st.nextToken());
					b[num]=true;
					break;
				case "remove":
					num=Integer.parseInt(st.nextToken());
					if(b[num]){
						b[num]=false;
					}
					break;
				case "check":
					num=Integer.parseInt(st.nextToken());
					if(b[num]){
						sb.append(1+"\n");
					}else{
						sb.append(0+"\n");
					}
					break;
				case "toggle":
					num=Integer.parseInt(st.nextToken());
					if(b[num]){
						b[num]=false;
					}else{
						b[num]=true;
					}
					break;
				case "all":
					Arrays.fill(b,true);
					break;
				case "empty":
					Arrays.fill(b,false);
					break;
			}
		}
		System.out.print(sb);
	}
}
