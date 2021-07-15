# https://www.acmicpc.net/problem/14502
s = []
# 좌우하상
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
max_result = 0
def bfs():
    global max_result
    copy = [[0] * m for i in range(n)]
    for i in range(n):
        for j in range(m):
            copy[i][j] = s[i][j]
    result = 0
    # 바이러스 집어넣음
    arr = []
    for i in range(n):
        for j in range(m):
            if copy[i][j] == 2:
                arr.append([i, j])
    #바이럿 검사
    while arr:
        a, b = arr[0][0], arr[0][1]
        del arr[0]
        #상하좌우 검사해서
        for i in range(4):
            ax = a + dx[i]
            ay = b + dy[i]
            # 맵 밖으로 안나가면
            if 0 <= ax and 0 <= ay and ax < n and ay < m:
                # 벽이 아니고 0이면
                if copy[ax][ay] == 0:
                    #감염
                    copy[ax][ay] = 2
                    #다시 바이러스 집어넣음
                    arr.append([ax, ay])
    #바이러스 아니면
    for i in copy:
        for j in i:
            if j == 0:
                result += 1

    max_result = max(max_result, result)


def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if s[i][j] == 0:
                s[i][j] = 1
                wall(cnt + 1)
                s[i][j] = 0
n, m = map(int, input().split())
for i in range(n):
    s.append(list(map(int, input().split())))
wall(0)
print(max_result)