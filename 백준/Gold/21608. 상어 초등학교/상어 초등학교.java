
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] chair=new int[N][N];
		int[][] score=new int[N*N][4];
		
		int result=0;
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int student=Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				score[student-1][j]=Integer.parseInt(st.nextToken());
			}
			int likeCount=-1;
			int vaccum=-1;
			
			int row=0,col=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(chair[r][c]!=0) continue;
					int likeTemp=0;
					int vaccumTemp=0;
					for(int d=0;d<4;d++) {
						int nx=r+dx[d];
						int ny=c+dy[d];
						if(nx<0||ny<0||nx>=N||ny>=N) {
							continue;
						}
						for(int l=0;l<4;l++) {
							if(chair[nx][ny]==score[student-1][l]) {
								likeTemp++;
							}
							if(chair[nx][ny]==0) {
								vaccumTemp++;
							}
						}
						
					}
					
					if(likeCount<likeTemp) {
						likeCount=likeTemp;
						vaccum=vaccumTemp;
						row=r;
						col=c;
						continue;
					}else if(likeCount==likeTemp&&vaccum<vaccumTemp) {
						likeCount=likeTemp;
						vaccum=vaccumTemp;
						row=r;
						col=c;
						continue;
					}
					
					
				}
			}
			
			chair[row][col]=student;
			
		}
		
		result=calculateScore(chair,score,N);
		
		
		
		System.out.println(result);
	}
	public static int calculateScore(int[][] chair,int[][] score,int N) {
		int result=0;
		
		for(int i=0;i<chair.length;i++) {
			for(int j=0;j<chair[i].length;j++) {
				int likeCount=0;
				int student=chair[i][j]-1;
				for(int d=0;d<4;d++) {
					int nx=i+dx[d];
					int ny=j+dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N) {
						continue;
					}
					for(int l=0;l<4;l++) {
						if(chair[nx][ny]==score[student][l]) {
							likeCount++;
						}
					}
				}
				if (likeCount > 0) {
					result+=Math.pow(10, likeCount-1);
				}
			}
		}
		return result;
	}
}
