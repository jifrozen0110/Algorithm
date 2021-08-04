n = int(input())

t = []
p = []

for i in range(n):
    T, P = map(int, input().split())
    t.append(T)
    p.append(P)
dp = [0] * (n + 1)
for j in range(n - 1, -1, -1):
    if t[j] + j <= n:
        dp[j] = max(dp[j + 1], p[j] + dp[j + t[j]])
    else:
        dp[j] = dp[j + 1]

print(dp[0])
