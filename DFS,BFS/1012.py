import sys

sys.setrecursionlimit(10000)

T = int(input())
count = []
for t in range(T):
    m, n, k = map(int, input().split())

    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    data = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]

    result = 0

    for i in range(k):
        x, y = map(int, input().split())
        data[y][x] = 1


    def dfs(a, b):
        visited[a][b] = 1
        for i in range(4):
            if n > a + dy[i] >= 0 and m > b + dx[i] >= 0:
                if visited[a + dy[i]][b + dx[i]] == 0 and data[a + dy[i]][b + dx[i]] == 1:
                    visited[a + dy[i]][b + dx[i]] = 1
                    dfs(a + dy[i], b + dx[i])


    for i in range(n):
        for j in range(m):
            if visited[i][j] == 0 and data[i][j] == 1:
                dfs(i, j)
                result += 1

    count.append(result)

for i in range(len(count)):
    print(count[i])
