n, m = map(int, input().split())
data = [int(input()) for _ in range(n)]

# 모두 구할 수 없다고 기정
dp = [10001] * (m + 1)


dp[0] = 0
for i in range(n):
    # 거스름돈 부터 M+1까지 -> 거스름돈 이하는 어차피 구할 수 없음
    for j in range(data[i], m + 1):
        # 현재 돈에서 - 거스름돈이 존재하는 값이면
        if dp[j - data[i]] != 10001:
            # 작은거 선택
            dp[j] = min(dp[j], dp[j - data[i]] + 1)

if dp[m] == 10001:
    print(-1)
else:
    print(dp[m])
