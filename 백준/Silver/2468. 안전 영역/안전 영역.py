import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

move = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N = int(input())
map = [list(map(int, input().strip().split())) for _ in range(N)]

max_rain = max(max(row) for row in map)
min_rain = min(min(row) for row in map)
answer = 1

def depthSearch(visited, x, y, limit):
    visited[x][y] = True
    for dx, dy in move:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and map[nx][ny] > limit:
            depthSearch(visited, nx, ny, limit)

def searchSection(rain):
    visited = [[False] * N for _ in range(N)]
    cnt = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and map[i][j] > rain:
                depthSearch(visited, i, j, rain)
                cnt += 1
    return cnt

for rain in range(min_rain, max_rain + 1):
    answer = max(answer, searchSection(rain))

print(answer)
