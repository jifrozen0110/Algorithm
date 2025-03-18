import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (char c : str.toCharArray()) {
                switch (c) {
                    case '<':
                        if (index > 0) {
                            index--;
                        }
                        break;
                    case '>':
                        if (index < sb.length()) {
                            index++;
                        }
                        break;
                    case '-':
                        if (index > 0) {
                            sb.deleteCharAt(index - 1);
                            index--;
                        }
                        break;
                    default:
                        sb.insert(index, c);
                        index++;
                        break;
                }
            }

            System.out.println(sb.toString());
        }
    }
}
