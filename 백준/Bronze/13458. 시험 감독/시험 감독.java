
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] people=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		long result=0;
		
		for(int i=0;i<N;i++) {
			result++;
			if(people[i]>B) {
				result+=(people[i]-B)/C;
				if((people[i]-B)%C>0) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
