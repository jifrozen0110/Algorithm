n, m = map(int, input().split())
data = []
for i in range(n):
    data.append(list(map(int, input())))


def dfs(x, y):
    # 밖으로 나가는 경우
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    # 0이면 1로 방문 처리하고 상하좌우 재귀적으로 살펴봄
    if data[x][y] == 0:
        data[x][y] = 1
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True
    return False


result = 0
# 모든 노드 확인
for i in range(n):
    for j in range(m):
        # 재귀적으로 살피면서 0 (1)-> 0 (1)-> 0 (1)-> 1 return True
        if dfs(i, j) == True:
            result += 1

print(result)
