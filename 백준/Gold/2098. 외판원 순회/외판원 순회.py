import sys
input = sys.stdin.readline

n = int(input())
INF = int(1e9)
arr = [list(map(int, input().split())) for _ in range(n)]

dp = {}

def dfs(visited, city):
    if visited == (1 << n) - 1:
        return arr[city][0] if arr[city][0] > 0 else INF

    if (visited, city) in dp:
        return dp[(visited, city)]

    min_cost = INF
    for next_city in range(n):
        if not (visited & (1 << next_city)) and arr[city][next_city] > 0:
            min_cost = min(min_cost,
                           dfs(visited | (1 << next_city), next_city) + arr[city][next_city])

    dp[(visited, city)] = min_cost
    return dp[(visited, city)]

result = dfs(1, 0)
print(result if result != INF else -1)
