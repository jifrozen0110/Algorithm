import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 최대매출 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int answer = 0;
            for (int j = i; j < k + i; j++) {
                answer += arr[j];
            }
            if (max < answer) {
                max = answer;
            }
        }

        System.out.print(max);

    }

}
