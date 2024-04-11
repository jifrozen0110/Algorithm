

import java.io.*;
import java.util.*;

public class Main {
    static int[][] ladder;
    static int N, H;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        ladder = new int[H][N-1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            ladder[a][b] = 1;
        }
        
        if (check()) {
            System.out.println(0);
            return;
        }
        
        for (int c = 1; c <= 3; c++) {
            DFS(0, c, 0, 0);
            if (answer != Integer.MAX_VALUE) {
                System.out.println(answer);
                return;
            }
        }
        
        System.out.println(-1);
    }
    
    public static boolean check() {
        for (int start = 0; start < N; start++) {
            int k = start;
            for (int y = 0; y < H; y++) {
                if (k > 0 && ladder[y][k - 1] == 1) {
                    k--;
                } else if (k < N - 1 && ladder[y][k] == 1) {
                    k++;
                }
            }
            if (k != start) return false;
        }
        return true;
    }
    
    public static void DFS(int count, int limit, int x, int y) {
        if (count == limit) {
            if (check()) {
                answer = Math.min(answer, count);
            }
            return;
        }
        
        for (int i = x; i < H; i++) {
            for (int j = (i == x ? y : 0); j < N - 1; j++) {
                if (ladder[i][j] == 0 &&
                    (j == 0 || ladder[i][j - 1] == 0) &&
                    (j == N - 2 || ladder[i][j + 1] == 0)) {
                    ladder[i][j] = 1;
                    DFS(count + 1, limit, i, j + 2);
                    ladder[i][j] = 0;
                }
            }
        }
    }
}