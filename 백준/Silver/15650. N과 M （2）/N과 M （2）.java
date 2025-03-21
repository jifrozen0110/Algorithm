
import java.util.*;
import java.io.*;

public class Main {
    public static void println(Object value) {
        System.out.println(value);
    }

    public static void DFS(int start, int cnt, int target, boolean[] visited, int total, String word) {
        if (cnt == target) {
            System.out.println(word);
            return;
        }
        for (int i = start + 1; i <= total; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, cnt + 1, target, visited, total, word + " " + i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, 1, M, visited, N, i + "");
            visited[i] = false;
        }

    }

}
