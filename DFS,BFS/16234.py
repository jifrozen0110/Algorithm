from collections import deque

# NLR
n, l, r = map(int, input().split())
# 지도
data = []
# 방문기록
visited = [[0] * n for _ in range(n)]
# 연합
union = []
#상하좌우
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    data.append(list(map(int, input().split())))

result = 0
queue = deque()


while True:
    # 연합국 있는지 없는지(True 빠져나오기 위한)
    ischecked = False
    for i in range(n):
        for j in range(n):
            # 반문 안했으면
            if visited[i][j] == 0:
                visited[i][j] = 1
                sum = data[i][j]
                queue.append([i, j])
                union = [[i, j]]

                while queue:
                    x, y = queue.popleft()
                    #상하좌우 검사
                    for o in range(4):
                        ix = x + dx[o]
                        iy = y + dy[o]
                        #맵 빠져나가면
                        if ix < 0 or ix >= n or iy < 0 or iy >= n:
                            continue
                        # l 보다 크고 r보다 적으면서 방문안한 지역
                        if l <= abs(data[x][y] - data[ix][iy]) <= r and visited[ix][iy] == 0:
                            ischecked = True
                            #방문기록
                            visited[ix][iy] = 1
                            # sum 더함
                            sum += data[ix][iy]
                            # 연합국 더함
                            union.append([ix, iy])
                            # 큐에 더함
                            queue.append([ix, iy])
                # 한개 따라 연합국 모두 더하면 연합국에 따라 다 더한값/연합국 개수 인구수 바꿔줌
                for g, h in union:
                    data[g][h] = sum // len(union)
    # 연합국 존재하면
    if ischecked:
        result += 1
    # 연합국 없으면 종료
    else:
        break
    # 다시 초기화 하는 이유? 방문 기록을 없애야 새롭게 연합국 맺을 수 잇음
    visited = [[0] * n for _ in range(n)]

print(result)
