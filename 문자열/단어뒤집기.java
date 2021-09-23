import java.util.*;;

public class Main {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            /*
             * int lt=0 rt=tmp.length()-1
             *
             * while(lt<rt){
             *
             * char tmp=s[lt]; s[lt]=s[rt] s[rt]=tmp lt++; rt--;
             *
             * }
             */
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String c : solution(n, str)) {
            System.out.println(c);
        }
    }

}
