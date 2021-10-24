package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1697
public class 숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] visited = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		if (n == k) {
			System.out.print(0);
			return;
		}
		q.offer(n);
		visited[n] = 1;
		while (!q.isEmpty()) {
			int a = q.poll();

			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = a + 1;
				} else if (i == 1) {
					next = a - 1;
				} else {
					next = a * 2;
				}
				if (next == k) {
					System.out.print(visited[a]);
					return;
				}
				if (next >= 0 && next < visited.length && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[a] + 1;
				}

			}

		}

	}
}
