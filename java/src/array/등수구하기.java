package array;

import java.util.*;

public class 등수구하기 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int score = 1;
            for (int j = 0; j < n; j++) {
                if (num < arr[j]) {
                    score += 1;
                }
            }
            answer[i] = score;
        }
        for (int rank : answer) {
            System.out.print(rank + " ");
        }
        sc.close();
    }
}