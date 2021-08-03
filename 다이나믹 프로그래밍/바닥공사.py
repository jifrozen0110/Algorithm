n = int(input())
dp = [0] * 1001
# 2*1 한개
dp[1] = 1
# 2*2 1*2 2개 2*1 2개 -> 3개
dp[2] = 3

for i in range(3, n + 1):
    # dp[i-2] -> 2*2 만들 수 있는 경우 2개 (2*2 / 1*2 2개) 따라서 2 곱함
    dp[i] = dp[i - 1] + dp[i - 2] * 2

print(dp[n])
