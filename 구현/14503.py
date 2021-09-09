N, M = map(int, input().split())
r, c, d = map(int, input().split())
mapC = []
for i in range(N):
    mapC.append(list(map(int, input().split())))
# 북, 동, 남, 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 왼쪽 회전
def rotate(d):
    if d == 0:
        d = 3
    else:
        d -= 1
    return d

# 초기 방문 & 청소 처리
mapC[r][c] = 2
result = 1

while True:
    isChange = False
    for i in range(4):
        d = rotate(d)
        nr = r + dx[d]
        nc = c + dy[d]
        # 지도 바깥으로 나가는지 처리
        if (0 <= nr < N) and (0 <= nc < M):
            if mapC[nr][nc] == 0:
                mapC[nr][nc] = 2
                r = nr
                c = nc
                result += 1
                isChange = True
                break
    if not isChange:
        # 후진
        nr = r - dx[d]
        nc = c - dy[d]
        if (0 > nr or nr >= N) or (0 > nc or nc >= M):
            break
        # 후진 -> 벽이면
        if mapC[nr][nc] == 1:
            break
        # 벽 아니면 후진 처리
        else:
            r, c = nr, nc

print(result)
