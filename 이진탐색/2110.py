# https://www.acmicpc.net/problem/2110
n, c = map(int, input().split())

data = [int(input()) for _ in range(n)]
data.sort()
start = 1
end = data[-1] - data[0]
result = 0
while start <= end:
    mid = (start + end) // 2
    a = data[0]
    count = 1

    for i in range(1, len(data)):
        if data[i] >= a + mid:
            count += 1
            a = data[i]

    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)
