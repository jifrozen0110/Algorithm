# https://www.acmicpc.net/problem/7576
from collections import deque

n, m = map(int, input().split())

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

data = [list(map(int, input().split())) for _ in range(m)]

queue = deque([])

for i in range(m):
    for j in range(n):
        if data[i][j] == 1:
            queue.append([i, j])

while queue:
    a, b = queue.popleft()
    for i in range(4):
        if a + dy[i] < 0 or m <= a + dy[i] or n <= b + dx[i] or b + dx[i] < 0:
            continue
        if data[a + dy[i]][b + dx[i]] == 0:
            data[a + dy[i]][b + dx[i]] = 1 + data[a][b]
            queue.append([a + dy[i], b + dx[i]])

total = data[0][0]
isZero = False
for i in range(m):
    for j in range(n):
        if data[i][j] != 0:
            total = max(data[i][j], total)
        else:
            print(-1)
            isZero = True
            break

    if isZero:
        break

if not isZero:
    print(total - 1)
