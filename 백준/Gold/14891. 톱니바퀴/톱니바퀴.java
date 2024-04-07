
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int[][] wheels=new int[4][8];
		
		for(int i=0;i<4;i++) {
			String wheel=br.readLine();
			int j=0;
			for(char c:wheel.toCharArray()){
				wheels[i][j++]=c-'0';
			}
		}
		
		int K=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(K-->0) {
			st=new StringTokenizer(br.readLine());
			int[] isTurn=new int[4];
			int number=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			isTurn[number-1]=d;
			for(int i=number;i<4;i++) {
				if(wheels[i-1][2]==wheels[i][6]) {
					break;
				}else {
					isTurn[i]=-isTurn[i-1];
				}
			}
			for(int i=number-1;i>0;i--) {
				if(wheels[i][6]==wheels[i-1][2]) {
					break;
				}else {
					isTurn[i-1]=-isTurn[i];
				}
			}
			
			for(int i=0;i<4;i++) {
				if(isTurn[i]==1) {
					wheels[i]=roatate(wheels[i]);
				}else if(isTurn[i]==-1) {
					wheels[i]=reverseRoatate(wheels[i]);
				}
			}
			
		}
		
		int score=calculateScore(wheels);
		
		System.out.println(score);
		
		
		
	}
	public static int calculateScore(int[][] wheels) {
		int score=0;
		for(int i=0;i<4;i++) {
			if(wheels[i][0]==1) {
				score+=Math.pow(2, i);
			}
		}
		return score;
	}
	public static int[] roatate(int[] wheel) {
		int[] rotateWheel=new int[8];
		int temp=wheel[7];
		for(int i=1;i<8;i++) {
			rotateWheel[i]=wheel[i-1];
		}
		rotateWheel[0]=temp;
		return rotateWheel;
	}
	public static int[] reverseRoatate(int[] wheel) {
		int[] rotateWheel=new int[8];
		int temp=wheel[0];
		for(int i=0;i<7;i++) {
			rotateWheel[i]=wheel[i+1];
		}
		rotateWheel[7]=temp;
		return rotateWheel;
	}
}
