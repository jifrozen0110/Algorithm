n = int(input())
data = list(map(int, input().split()))
# 식량창고 개수
d = [0] * 100


d[0] = data[0]
d[1] = max(data[1], data[0])
for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + data[i])

print(d[n - 1])
