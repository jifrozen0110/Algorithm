import java.util.*;

public class Main {
    public static String solution(String str) {
        String answer = "NO";
        // replaceAll [^A-Z] -> A-Z가 아니면 다 바꾸기
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp))
            return "YES";
        else
            return answer;

    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));

    }
}