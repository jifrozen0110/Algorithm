import sys
input = sys.stdin.readline

N, M = map(int, input().split())

dp = [0] * (M + 1)

for _ in range(N):
    w, v, cnt = map(int, input().split())
    
    k = 1
    while cnt > 0:
        num = min(k, cnt)
        cnt -= num
        weight = w * num
        value = v * num
        for t in range(M, weight - 1, -1):
            dp[t] = max(dp[t], dp[t - weight] + value)
        k *= 2

print(dp[M])
