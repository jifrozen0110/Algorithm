from collections import deque

n, m = map(int, input().split())
# 미로 맵
data = []
for i in range(n):
    data.append(list(map(int, input())))

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    # 큐 deque 선언
    queue = deque()
    # 큐 안에 갈 수 잇는 좌표 집어 넣음
    queue.append((x, y))
    # 큐 빌때까지 반복
    while queue:
        # 큐 선입선출
        x, y = queue.popleft()
        # 상하좌우로 이동해야힘
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 미로 밖으로 나가는 경우
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
                # 괴물 있는 경우
            if data[nx][ny] == 0:
                continue
            # 갈 수 잇는 경우
            if data[nx][ny] == 1:
                # 이전 1 -> 2 -> 3 이런식으로 이동하면서 얼만큼 이동했는지 구하기 위해 이전 좌표값을 더해줌
                # (1,1)=1 (1,2)=(1,1)+1=2 이런식으로
                data[nx][ny] = data[x][y] + 1
                # 갈 수 있는좌표 다시 큐에 더해줌
                queue.append((nx, ny))
    # 제일 마지막칸 값을 구함
    return data[n - 1][m - 1]


print(bfs(0, 0))
