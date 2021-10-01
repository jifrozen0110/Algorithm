import java.util.*;

public class 봉우리 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        int[][] arr = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;

                    }
                }
                if (flag) {
                    answer++;
                }

            }

        }
        System.out.print(answer);
        sc.close();
    }
}