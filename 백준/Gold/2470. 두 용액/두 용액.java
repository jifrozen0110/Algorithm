
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());

		int[] map=new int[N];



		for(int i=0;i<N;i++){
			map[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(map);

		int start=0;
		int end=N-1;
		int gap=Integer.MAX_VALUE;
		int temp1=0,temp2=0;

		while(start<end){
			int sum=map[start]+map[end];
			if(Math.abs(sum)<gap){
				gap=Math.abs(sum);
				temp1=map[start];
				temp2=map[end];
			}
			if(sum>0){
				end=end-1;
			}else{
				start=start+1;
			}
		}

		System.out.println(temp1+" "+temp2);


	}
}
