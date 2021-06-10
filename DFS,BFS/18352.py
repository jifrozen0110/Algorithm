# https://www.acmicpc.net/problem/18352
from collections import deque

n, m, k, x = map(int, input().split())
data = [[] * n for _ in range(n)]
visited = [-1] * n
for i in range(m):
    a, b = map(int, input().split())
    data[a - 1].append(b - 1)

queue = deque([x - 1])
visited[x - 1] = 0

while queue:
    a = queue.popleft()
    for i in data[a]:
        if visited[i] == -1:
            visited[i] = visited[a] + 1
            queue.append(i)

check = False
for i in range(n):
    if visited[i] == k:
        print(i + 1)
        check = True

if check == False:
    print(-1)
