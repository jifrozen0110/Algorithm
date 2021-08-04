T = int(input())
while T:
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    dp = []
    count = 0
    for i in range(n):
        dp.append(data[count:count + m])
        count += m

    for k in range(1, m):
        for j in range(n):
            # 첫번째 줄
            if i == 0:
                dp[j][k] = dp[j][k] + max(dp[j + 1][k - 1], dp[j][k - 1])
            # 마지막줄
            elif i == n - 1:
                dp[j][k] = dp[j][k] + max(dp[j - 1][k - 1], dp[j][k - 1])
            else:
                dp[j][k] = dp[j][k] + max(dp[j + 1][k - 1], dp[j][k - 1], dp[j - 1][k - 1])

    print(max(dp[n - 1]))
