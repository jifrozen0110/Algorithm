package array;
import java.util.*;

public class 점수계산 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int score = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 1) {
                s += 1;
                score += s;
            } else {
                s = 0;
            }
        }
        System.out.print(score);
        sc.close();
    }
}