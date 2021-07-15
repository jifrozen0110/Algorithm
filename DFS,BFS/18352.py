# https://www.acmicpc.net/problem/18352
from collections import deque

n, m, k, x = map(int, input().split())
data = [[] * n for _ in range(n)]
visited = [-1] * n
for i in range(m):
    a, b = map(int, input().split())
    data[a - 1].append(b - 1)

# 처음 시작 지점부터 넣어줌
queue = deque([x - 1])
# 처음 시작 지점 0
visited[x - 1] = 0

while queue:
    a = queue.popleft()
    # data값 다 불러옴
    for i in data[a]:
        # 방문 안했으면
        if visited[i] == -1:
            # 이전 값 넣어서 +1 -> 최소 거리 구할때 무조건 이렇게 한다.
            visited[i] = visited[a] + 1
            queue.append(i)

#최단 거리인 도시 존재하지 않을때 -1 표시하기 위해서
check = False
# 모든 방문 기록
for i in range(n):
    # 원하는 거리 정보이면
    if visited[i] == k:
        # 도시 표시
        print(i + 1)
        check = True

if check == False:
    print(-1)
