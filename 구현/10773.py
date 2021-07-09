# https://www.acmicpc.net/problem/10773

n = int(input())
data = []
for i in range(n):
    a = int(input())
    if a == 0:
        data.pop()
    else:
        data.append(a)

print(sum(data))
