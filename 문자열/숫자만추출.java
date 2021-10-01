import java.util.*;

public class 숫자만추출 {
    public static int solution(String str) {
        str = str.toUpperCase().replaceAll("[A-Z]", "");
        int n = Integer.valueOf(str);// Integer.parseInt(str)
        return n;

    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
        kb.close();
    }
}