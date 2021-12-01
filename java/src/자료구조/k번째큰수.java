package 자료구조;
import java.util.*;
import java.io.*;

public class k번째큰수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		int[] arr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		TreeSet<Integer> Tset=new TreeSet<>(Collections.reverseOrder());

		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int l=j+1;l<n;l++){
					Tset.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}
		int cnt=0;
		int answer=-1;
		for(int x:Tset){
			cnt++;
			if(cnt==k) {answer=x; break;}
		}

		System.out.print(answer);
	}
}
