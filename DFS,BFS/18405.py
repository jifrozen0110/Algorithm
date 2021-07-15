# https://www.acmicpc.net/problem/18405
from collections import deque

n, k = map(int, input().split())
data = []
for i in range(n):
    data.append(list(map(int, input().split())))

s, x, y = map(int, input().split())

time = 0
# 상하좌우
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

queue = []
for i in range(n):
    for j in range(n):
        # 바이러스 이면 다 집어넣기
        if data[i][j] != 0:
            # data[i][j](바이러스 종류) i,j(좌표) , 시간
            queue.append([data[i][j], i, j, time])
# 바이러스 종류 정렬
queue.sort()

queue = deque(queue)

while queue:
    virus, a, b, time = queue.popleft()
    if time == s:
        break
    for i in range(4):
        rx = a + dx[i]
        ry = b + dy[i]
        if rx < 0 or ry < 0 or rx >= n or ry >= n:
            continue
        if data[rx][ry] == 0:
            data[rx][ry] = data[a][b]
            queue.append([data[rx][ry], rx, ry, time + 1])

print(data[x - 1][y - 1])
