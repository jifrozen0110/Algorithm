# https://www.acmicpc.net/problem/1181
n = int(input())

data = []
for i in range(n):
    data.append((input()))
data = set(data)
data = sorted(data, key=lambda data: (len(data), data))

for i in range(len(data)):
    print(data[i])
