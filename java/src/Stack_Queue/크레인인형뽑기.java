package Stack_Queue;
import java.util.*;
import java.io.*;

public class 크레인인형뽑기 {
	public static void main(String[] agrs) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int m=Integer.parseInt(br.readLine());
		int[] moves=new int[m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++){
			moves[i]=Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack=new Stack<>();
		stack.add(0);
		int answer=0;
		for(int i=0;i<m;i++){
			int num=moves[i];
			for(int j=0;j<n;j++){
				if(arr[j][num-1]!=0){
					if(arr[j][num-1]==stack.peek()){
						stack.pop();
						answer+=2;
					}else {
						stack.push(arr[j][num - 1]);
					}
					arr[j][num-1]=0;
					break;
				}
			}

		}

		System.out.print(answer);

	}
}
