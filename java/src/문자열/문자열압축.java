package 문자열;
import java.util.*;

public class 문자열압축 {
    public static String solution(String str) {
        String answer = "";
        int compression = 1;
        str = str + " ";
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                compression++;
            } else {
                answer += str.charAt(i);
                if (compression > 1) {
                    answer += compression;
                }
                compression = 1;
            }

        }

        return answer;

    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
        kb.close();
    }
}