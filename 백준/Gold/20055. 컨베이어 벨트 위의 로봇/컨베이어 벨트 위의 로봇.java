

import java.io.*;
import java.util.*;

public class Main {
	static int N=0;
	static int[] robots;
	static int[] abilities;
	
public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		abilities=new int[N*2];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N*2;i++) {
			abilities[i]=Integer.parseInt(st.nextToken());
		}
		
		robots=new int[N*2];
		
		int result=1;
		while(true) {
			
			// step 1.
			abilities=rotate(abilities);
			robots=rotate(robots);
			
			if(robots[N-1]==1) {
				robots[N-1]=0;
			}
			
			//step 2.
			moveRobot();
			
			if(robots[N-1]==1) {
				robots[N-1]=0;
			}
			
			//step 3.
			if(abilities[0]>0&&robots[0]==0) {
				robots[0]=1;
				abilities[0]--;
			}
			
			//step 4.
			int count=calculateAbility();
			if(count>=K) {
				break;
			}
			
			result++;
			
		}
		System.out.println(result);
		
	}
	public static int calculateAbility() {
		int countZero=0;
		
		for(int i=0;i<abilities.length;i++) {
			if(abilities[i]==0) {
				countZero++;
			}
		}
		
		return countZero;
	}
	
	public static int[] rotate(int[] arr) {
		int[] newA=new int[arr.length];
		int temp=arr[arr.length-1];
		for(int i=1;i<arr.length;i++) {
			newA[i]=arr[i-1];
		}
		newA[0]=temp;
		return newA;
	}
	
	public static void moveRobot() {
		for(int i=robots.length-1;i>0;i--) {
			if(robots.length-1==i&&robots[i]==1) {
				if(robots[0]==0&&abilities[0]>0) {
					robots[0]=1;
					abilities[0]--;
					robots[i]=0;
				}
			}
			if(robots[i]==1) {
				if(robots[i+1]==0&&abilities[i+1]>0) {
					robots[i+1]=1;
					abilities[i+1]--;
					robots[i]=0;
				}
			}
		}
		
	}


}
