
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<FireBall> fireBalls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            Map<Integer, List<FireBall>> map = new HashMap<>();
            for (FireBall ball : fireBalls) {
                int nr = (ball.r + dx[ball.d] * (ball.s % N) + N * 1000) % N;
                int nc = (ball.c + dy[ball.d] * (ball.s % N) + N * 1000) % N;
                int index = nr * N + nc;
                map.computeIfAbsent(index, x -> new ArrayList<>()).add(new FireBall(nr, nc, ball.m, ball.s, ball.d));
            }

            fireBalls.clear();
            for (List<FireBall> balls : map.values()) {
                if (balls.size() == 1) {
                    fireBalls.addAll(balls);
                    continue;
                }
                
                int totalMass = 0, totalSpeed = 0;
                int even = 0, odd = 0;
                for (FireBall ball : balls) {
                    totalMass += ball.m;
                    totalSpeed += ball.s;
                    if (ball.d % 2 == 0) even++;
                    else odd++;
                }
                
                if (totalMass / 5 == 0) continue;
                int newSize = balls.size();
                int newMass = totalMass / 5;
                int newSpeed = totalSpeed / newSize;

                for (int i = 0; i < 4; i++) {
                    int newDirection = (even == 0 || odd == 0) ? 2 * i : 2 * i + 1;
                    fireBalls.add(new FireBall(balls.get(0).r, balls.get(0).c, newMass, newSpeed, newDirection));
                }
            }
        }

        int result = 0;
        for (FireBall ball : fireBalls) {
            result += ball.m;
        }
        System.out.println(result);
    }
}