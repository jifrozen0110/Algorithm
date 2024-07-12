import java.util.*;
class Solution {

    static int INF=100001*200;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][] map = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }
        
        for (int[] fare : fares) {
            int first = fare[0];
            int second = fare[1];
            int cost = fare[2];
            map[first][second] = cost;
            map[second][first] = cost;
        }
        
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }
        
        // Floyd-Warshall 알고리즘 적용
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        // s에서 각각 a와 b로 가는 최소 비용 계산
        answer = map[s][a] + map[s][b];
        
        // 경유지 i를 통해 가는 최소 비용 계산
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
            }
        }
        
        return answer;
    }
    
}