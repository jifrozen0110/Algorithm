# https://www.acmicpc.net/problem/10451
import sys

# 런타임 에러 (RecursionError) 해결
sys.setrecursionlimit(10000)
t = int(input())


# dfs
def dfs(h, k, visited, data):
    visited[h] = 1
    if visited[k - 1] == 0:
        dfs(k - 1, data[k - 1], visited, data)


# 순열 사이클인데
# 이렇게 생각했다.
# 3 -> data[3-1](7) -> data[7-10](5) -> data[5-1](1) 순열
# 무조건 순열은 생겨야한다 (그게 문제 조건임) 그렇기 때문에 방문기록만 확인하면 된다.
result = [0] * t
for i in range(t):
    result[i] = 0
    n = int(input())
    visited = [0] * n
    data = list(map(int, sys.stdin.readline().split()))
    for h in range(n):
        if visited[h] == 0:
            result[i] += 1
            dfs(h, data[h], visited, data)

for r in result:
    print(r)
