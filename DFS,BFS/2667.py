# https://www.acmicpc.net/problem/2667
n = int(input())
data = []

for i in range(n):
    data.append(list(map(int, input())))

visited = [[0] * (n + 1) for i in range(n + 1)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def dfs(a, b):
    global result
    result += 1
    visited[a][b] = 1
    for i in range(4):
        if n > a + dy[i] >= 0 and n > b + dx[i] >= 0:
            if visited[a + dy[i]][b + dx[i]] == 0 and data[a + dy[i]][b + dx[i]] == 1:

                visited[a + dy[i]][b + dx[i]] == 1
                dfs(a + dy[i], b + dx[i])


result = 0
apt = []
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0 and data[i][j] == 1:
            dfs(i, j)
            apt.append(result)
            result = 0

print(len(apt))
apt.sort()
for i in apt:
    print(i)
