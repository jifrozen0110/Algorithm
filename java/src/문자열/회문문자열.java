package 문자열;
import java.util.*;;

public class 회문문자열 {
    public static String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        // 1. 반만 비교하기
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return "NO";
        }
        // 2. StringBuilder(str).reverse().toString(); 으로 비교하기 if(equalsIgnoreCase ->
        // 대문자 소문자 상관없이 비교)

        // 3. 이진탐색 검사
        // char[] c = str.toCharArray();
        // int lt = 0, rt = str.length() - 1;
        // while (lt < rt) {
        // if (c[lt] != c[rt]) {
        // answer = "NO";
        // return answer;
        // } else {
        // lt++;
        // rt--;
        // }
        // }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
        kb.close();
    }

}
