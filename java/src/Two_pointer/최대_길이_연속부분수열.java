package Two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_길이_연속부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		int max=0;
		int lt=0;
		for(int rt=0;rt<n;rt++){
			if(arr[rt]==0){
				cnt++;
			}
			while(cnt>k) {
				if (arr[lt++] == 0) {
					cnt--;
				}
			}
			max=Math.max(rt-lt+1,max);
		}
		System.out.print(max);

	}
}
