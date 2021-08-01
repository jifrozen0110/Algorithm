from bisect import bisect

n = int(input())
data = list(map(int, input().split()))

# 연결선 이을 수 있으면
dp = [data[0]]
for i in range(1, n):
    # 연결선을 꼬인게 없는지 판단
    # 가능한 연결선 중 가장 큰 값과 비교
    if data[i] > dp[-1]:
        # 크면 집어넣음
        dp.append(data[i])
    else:
        # 작으면 그 값이 들어갈 수 잇는 index를 찾아서 그 인덱스를 교체
        dp[bisect(dp, data[i])] = data[i]
print(len(dp))
