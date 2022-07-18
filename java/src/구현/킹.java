package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 킹 {
	public static void main(String[] args) throws Exception{
		String[] direction={"R","L","B","T","RT","LT","RB","LB"};
		int[] dx={1,-1,0,0,1,-1,1,-1};
		int[] dy={0,0,-1,1,1,1,-1,-1};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		String s=st.nextToken();

		int king_x=s.charAt(0)-'A';
		int king_y=s.charAt(1)-'0'-1;

		s=st.nextToken();

		int rock_x=s.charAt(0)-'A';
		int rock_y=s.charAt(1)-'0'-1;

		int N=Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++){
			int d=getDirection(br.readLine());
			int k_nx=king_x+dx[d];
			int k_ny=king_y+dy[d];
			int r_nx= rock_x + dx[d];
			int r_ny=rock_y + dy[d];
			if(k_nx>=0&&k_nx<8&&k_ny>=0&&k_ny<8){
				king_x=k_nx;
				king_y=k_ny;
				if(king_x==rock_x&&king_y==rock_y) {
					if(r_nx>=0&&r_nx<8&&r_ny>=0&&r_ny<8) {
						rock_x = r_nx;
						rock_y = r_ny;
					}else{
						king_x=king_x-dx[d];
						king_y=king_y-dy[d];
					}
					}
				}
			}

		StringBuilder sb=new StringBuilder();

		sb.append((char)(king_x+65));
		sb.append(king_y+1+"\n");
		sb.append((char)(rock_x+65));
		sb.append(rock_y+1);
		System.out.println(sb);

	}
	public static int getDirection(String s){
		switch (s) {
			case "R": return 0;
			case "L": return 1;
			case "B": return 2;
			case "T": return 3;
			case "RT": return 4;
			case "LT": return 5;
			case "RB":return 6;
			case "LB":return 7;
		}
		return 0;
	}
}
