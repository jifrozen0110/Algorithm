# https://www.acmicpc.net/problem/10825

n = int(input())

data = []
for i in range(n):
    name, ko, en, math = input().split()
    data.append((name, int(ko), int(en), int(math)))

data = sorted(data, key=lambda data: (-data[1], data[2], -data[3], data[0]))

for i in range(n):
    print(data[i][0])
