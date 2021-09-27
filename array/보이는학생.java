import java.util.*;

public class Main {
    public static int solution(int n, int[] list) {
        int answer = 1;
        int max = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i] > max) {
                max = list[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(n, arr));

    }
}