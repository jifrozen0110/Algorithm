package Two_pointer;
import java.io.*;
import java.util.*;

public class 연속부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 투 포인터는 fot문 2개 보다는 포인터 변수를 두개둬서 시간복잡도를 줄이는것
        int result = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m)
                result++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m)
                    result++;
            }
        }

        System.out.println(result);

    }

}
