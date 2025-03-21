

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int start, int cnt, int target, boolean[] visited, int total, String word) {
        if (cnt == target) {
            sb.append(word + "\n");
            return;
        }
        for (int i = start; i <= total; i++) {
            DFS(i, cnt + 1, target, visited, total, word + " " + i);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            DFS(i, 1, M, visited, N, i + "");
        }
        System.out.println(sb.toString());

    }

}
