# https://www.acmicpc.net/problem/2178
from collections import deque

n, m = map(int, input().split())
data = []

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for i in range(n):
    data.append(list(map(int, input())))

visited = [[0] * (m + 1) for i in range(n + 1)]

queue = deque([[0,0]])
visited[0][0] = 1
while queue:
    a,b= queue.popleft()
    if (a+1)==n and (b+1)==m:
        print(visited[a][b])
        break
    for i in range(4):
        if n>a + dy[i]>=0 and m>b + dx[i]>=0:
            if data[a + dy[i]][b + dx[i]] == 1 and visited[a + dy[i]][b + dx[i]] == 0:
                queue.append([a + dy[i], b + dx[i]])
                visited[a + dy[i]][b + dx[i]] = visited[a][b]+1


