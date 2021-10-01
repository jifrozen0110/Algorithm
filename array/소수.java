import java.util.*;

public class 소수 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int[] list = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (list[i] == 0) {
                result++;
                for (int j = i; j <= n; j = j + i) {
                    list[j] = 1;
                }
            }
        }
        System.out.print(result);
        sc.close();
    }
}