

import java.io.*;
import java.util.*;

public class Main {
	static int MIN=Integer.MAX_VALUE;
	static int teamTotalScore=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] score=new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				score[i][j]=Integer.parseInt(st.nextToken());
				teamTotalScore+=score[i][j];
			}
		}
		
		divideTeam(new boolean[N],0,N,0,score);
		
		System.out.println(MIN);
	}
	public static void divideTeam(boolean[] visited, int start,int N,int index,int[][] teamScore) {
		if(index==N/2) {
			int result=calculateTeamScore(visited,teamScore);
			MIN=Math.min(MIN, result);
			return;
		}
		for(int i=start;i<N;i++) {
			visited[i]=true;
			divideTeam(visited,i+1,N,index+1,teamScore);
			visited[i]=false;
			
		}
	}
	public static int calculateTeamScore(boolean[] visited,int[][] teamScore) {
		int teamOneScore=0, teamTwoScore = 0;
		
		for(int i=0;i<visited.length;i++) {
				for(int j=0;j<visited.length;j++) {
					if(i==j) continue;
					 if (visited[i] && visited[j]) { // Team 1
		                    teamOneScore += teamScore[i][j];
		                } else if (!visited[i] && !visited[j]) { // Team 2
		                    teamTwoScore += teamScore[i][j];
		                }
				}
		}
		
		return Math.abs(teamOneScore-teamTwoScore);
	}

}
