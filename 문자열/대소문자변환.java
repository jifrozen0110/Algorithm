import java.util.*;;

public class 대소문자변환 {
    public static String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {// x>=97 && x<=122 -> 소문자 (char)(x-32) -> 대문자로 변환 대문자 -> x+32소문자
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
        kb.close();

    }

}
