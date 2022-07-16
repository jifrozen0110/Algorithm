package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_개발_2 {
	public static int turn(int direction){
		if(direction==0){
			return 3;
		}
		return direction-1;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());

		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int direction=Integer.parseInt(st.nextToken());

		int[][] map=new int[x][y];

		for(int i=0;i<x;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<y;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int cnt=0;
		int result=0;

		map[a][b]=2;

		while(true){
			direction = turn(direction);
			int nx = dx[direction] + a;
			int ny = dy[direction] + b;
			if(nx<0||nx>=x||ny<0||ny>=y){
				continue;
			}
			if(map[nx][ny]==0){
				a=nx;
				b=ny;
				map[nx][ny]=2;
				cnt=0;
				result++;
			}else{
				cnt++;
			}

			if(cnt==4){
				nx=a-dx[direction];
				ny=b-dy[direction];
				if(map[nx][ny]==0||map[nx][ny]==2){
					a=nx;
					b=ny;
					cnt=0;
					map[nx][ny]=2;
					result++;
				}else{
					break;
				}
			}
		}
		System.out.println(result);
	}
}
