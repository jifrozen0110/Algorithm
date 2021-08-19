import heapq
import sys

# 다익스트라
input = sys.stdin.readline
INF = sys.maxsize
n, m, k = map(int, input().split())

# 그래프 만들기
graph = [[] for _ in range(n + 1)]
# 거리를 구하는데 [[INF],[INF]..(k+1)개 -> 포장 0번한 경우 포장 1번한 경우 ... (k+1)번 한 경우] n+1개
distance = [[INF for _ in range(k + 1)] for _ in range(n + 1)]
# 양방향
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

# 다익스트라
def dijksta(start):
    q = []
    cnt = 0
    # 거리마다 포장 개수 넣어줌
    distance[start][cnt] = 0
    # 우선순위 큐에도 포장 도로 개수 넣어줌
    heapq.heappush(q, (0, start, cnt))

    while q:
        dist, now, cnt = heapq.heappop(q)
        # 현재 distance가 dist보다 작으면 안함
        if dist > distance[now][cnt]:
            continue
        # graph 꺼내기
        for i in graph[now]:
            # cost에 걸리는 시간(0) + 1 -> 3 (1) = 1
            # cost에 걸리는 시간(0) + 1 -> 2 (10) = 10
            cost = dist + i[1]
            # 포장 안하는 경우
            if cost < distance[i[0]][cnt]:
                # 2 거리 cost 대입
                distance[i[0]][cnt] = cost
                heapq.heappush(q, (cost, i[0], cnt))
            # 포장 하는 경우
            if cnt < k and distance[i[0]][cnt + 1] > dist:
                # 포장하면 그 포장한 도로의 거리는 0이므로 dist대입
                distance[i[0]][cnt + 1] = dist
                heapq.heappush(q, (dist, i[0], cnt + 1))


dijksta(1)

# (k+1)개 포장한 개수에서 가장 작은 값
print(min(distance[n]))
