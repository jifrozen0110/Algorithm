
import java.util.*;

public class Main {
    public static char[] solution(int n, int[] A, int[] B) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                answer[i] = 'D';
            } else if (A[i] == 1 && B[i] == 3)
                answer[i] = 'A';
            else if (A[i] == 2 && B[i] == 1)
                answer[i] = 'A';
            else if (A[i] == 3 && B[i] == 2)
                answer[i] = 'A';
            else
                answer[i] = 'B';

            // } else if (A[i] == 1 && B[i] == 3) {
            // answer[i] = 'A';
            // } else if (B[i] == 1 && A[i] == 3) {
            // answer[i] = 'B';
            // } else if (A[i] > B[i]) {
            // answer[i] = 'A';
            // } else if (A[i] < B[i]) {
            // answer[i] = 'B';
            // }
        }
        return answer;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for (char c : solution(n, A, B)) {
            System.out.println(c);
        }

    }
}