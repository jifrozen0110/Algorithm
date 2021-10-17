package 문자열;
import java.util.*;;

public class 문장속단어 {
    public static String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;// pos
        /**
         * while((pos=str.indexOf(' '))!=-1 )
         *
         * String temp=str.substring(0,pos); -> It/ is/ time ...
         *
         * str=str.substring(pos+1) 띄어쓰기 제외 그 다음 단어 얻기 위해
         *
         * 마지막 단어 따로 조건문으로 검사
         */
        String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
        kb.close();
    }

}
