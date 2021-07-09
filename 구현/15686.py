# https://www.acmicpc.net/problem/15686
from itertools import combinations

n, m = map(int, input().split())
data = []
for i in range(n):
    data.append(list(map(int, input().split())))

two = []
one = []
for i in range(n):
    for j in range(n):
        if data[i][j] == 2:
            two.append([i, j])
        if data[i][j] == 1:
            one.append([i, j])

chicken = list(combinations(two, m))
result = [0] * len(chicken)
for i in one:
    for j in range(len(chicken)):
        a = 100
        for k in chicken[j]:
            temp = abs(k[0] - i[0]) + abs(k[1] - i[1])
            a = min(a, temp)
        result[j] += a

print(min(result))
