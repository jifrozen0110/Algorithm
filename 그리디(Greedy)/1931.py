# https://www.acmicpc.net/problem/1931
# 회의실 배정
n = int(input())
data = []
for i in range(n):
    data.append(list(map(int, input().split())))
data.sort(key=lambda x: (x[0]))
data.sort(key=lambda x: (x[1]))
last = 0
result = 0
for i, j in data:
    if i >= last:
        result += 1
        last = j

print(result)
