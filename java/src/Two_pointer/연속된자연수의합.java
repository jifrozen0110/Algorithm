package Two_pointer;
import java.util.*;

public class 연속된자연수의합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n / 2 + 1;
        int result = 0;
        int sum = 0;
        int lt = 0;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                result++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    result++;
                }
            }

        }
        System.out.print(result);
        sc.close();
    }

}
