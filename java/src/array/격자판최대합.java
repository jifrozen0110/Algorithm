package array;

import java.util.*;

public class 격자판최대합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                max += arr[i][j];
            }
            answer = Math.max(max, answer);
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max += arr[j][i];
            }
            answer = Math.max(answer, max);
        }
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < n; i++) {

            max1 += arr[i][i];
            max2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, max1);
        answer = Math.max(answer, max2);
        System.out.print(answer);
        sc.close();
    }
}