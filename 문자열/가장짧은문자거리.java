import java.util.*;

public class Main {
    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = Math.min(answer[i], p);
        }
        return answer;

    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int x : solution(str, c)) {
            System.out.print(x + " ");
        }

    }
}