import java.util.*;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n + 1;
        int[][] arr = new int[cnt][6];
        for (int i = 1; i < cnt; i++) {
            for (int j = 1; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] answer = new int[cnt];
        Arrays.fill(answer, 0);
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i < cnt; i++) {
            for (int j = i; j < cnt; j++) {
                for (int d = 1; d < 6; d++) {
                    if (arr[i][d] == arr[j][d]) {
                        answer[i] += 1;
                        answer[j] += 1;
                        break;
                    }
                }
            }
            if (max < answer[i]) {
                max = answer[i];
                index = i;
            }
        }

        System.out.print(index);
        sc.close();
    }

}
