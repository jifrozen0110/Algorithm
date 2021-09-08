# https://www.acmicpc.net/problem/1946
T = int(input())
result = [0] * T
for t in range(T):
    N = int(input())
    data = []
    for i in range(N):
        a, b = map(int, input().split())
        data.append([a, b])

    data.sort()
    min_m = data[0][1]
    cnt = 0
    for i in range(1, N):
        if data[i][1] < min_m:
            min_m = data[i][1]
            cnt += 1

    result[t] = cnt + 1

for i in range(T):
    print(result[i])
