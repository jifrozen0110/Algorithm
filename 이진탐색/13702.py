# https://www.acmicpc.net/problem/13702
n, k = map(int, input().split())

data = [int(input()) for _ in range(n)]

start = 0
end = max(data)
result = 0
while start <= end:
    num = 0
    mid = (start + end) // 2
    for i in data:
        a = i // mid
        num += a
    if num < k:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)
