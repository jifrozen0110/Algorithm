import java.util.*;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int pi = 0, pj = 0;
        boolean isTrue = true;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                isTrue = true;
                for (int k = 0; k < m; k++) {
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi >= pj) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }

}
