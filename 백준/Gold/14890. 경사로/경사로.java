
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int result=0;
		
		for(int i=0;i<N;i++) {
			int count=L;
			int previous=map[i][0];
			boolean isPossible=true;
			for(int j=0;j<N;j++) {
				if(Math.abs(map[i][j]-previous)>1) {
					isPossible=false;
					break;
				}else if(Math.abs(map[i][j]-previous)==1) {
					if(map[i][j]>previous) {
						if(count<=0) {
							count=L-1;
							previous=map[i][j];
						}else {
						isPossible=false;
						break;
					}
					}else {
						previous=map[i][j];
						count=L;
						for(int k=0;k<L;k++) {
							if(j+k>=N) {
								isPossible=false;
								break;
							}
							if(map[i][j+k]==previous) {
								count--;
							}else {
								isPossible=false;
								break;
							}
						}
						if(!isPossible) break;

						count=L;
						j=j+L-1;
						
						
					}
				}else if(map[i][j]==previous) {
					count--;
				}
			}
			if(isPossible) {
				result++;}
		}
		
		for(int i=0;i<N;i++) {
			int count=L;
			int previous=map[0][i];
			boolean isPossible=true;
			for(int j=0;j<N;j++) {
				if(Math.abs(map[j][i]-previous)>1) {
					isPossible=false;
					break;
				}else if(Math.abs(map[j][i]-previous)==1) {
					
						if(map[j][i]>previous) {
							if(count<=0) {
								count=L-1;
								previous=map[j][i];
							}else {
							isPossible=false;
							break;
						}
						}else {
							previous=map[j][i];
							count=L;
							for(int k=0;k<L;k++) {
								if(j+k>=N) {
									isPossible=false;
									break;
								}
								if(map[j+k][i]==previous) {
									count--;
								}else {
									isPossible=false;
									break;
								}
							}
							if(!isPossible) break;

							count=L;
							j=j+L-1;
							
							
						}


				}else if(map[j][i]==previous) {
					count--;
				}
			}
			if(isPossible) {
				result++;}
		}
		
		System.out.println(result);
		
	}

}
