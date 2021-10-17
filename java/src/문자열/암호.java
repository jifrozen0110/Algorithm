package 문자열;
import java.util.*;

public class 암호 {
    public static String solution(int cnt, String str) {
        String answer = "";

        int s = 0;
        for (int i = 0; i < cnt; i++) {
            String tmp = str.substring(s, s + 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s + 7;
        }

        return answer;

    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        String str = kb.next();
        System.out.println(solution(cnt, str));
        kb.close();
    }
}