n = int(input())
data = list(map(int, input().split()))

dp = [1] * n
count = 0
for i in range(1, len(data)):
    for j in range(0, i):
        if data[i] < data[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
