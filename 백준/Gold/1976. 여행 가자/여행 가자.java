
import java.util.*;
import java.io.*;

public class Main {
    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        uf = new int[N + 1];
        for (int i = 1; i <= N; i++)
            uf[i] = i;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    merge(i, j);
                }
            }
        }

        // System.out.println(Arrays.toString(uf));

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean possible = true;
        int root = find(first);

        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) != root) {
                possible = false;
                break;
            }
        }

        System.out.println((possible) ? "YES" : "NO");

    }

    public static int find(int a) {
        if (uf[a] != a) {
            uf[a] = find(uf[a]);
        }
        return uf[a];
    }

    public static void merge(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            uf[parentB] = parentA;
        }
    }
}