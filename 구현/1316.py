# https://www.acmicpc.net/problem/1316

n = int(input())
alpha = [0] * 26
data = []
result = 0
for i in range(n):
    data.append(input())

for i in range(n):
    a = list(data[i])
    last = a[0]
    alpha[int(ord(last)) - 97] = 1
    for j in range(1, len(a)):
        if last == a[j]:
            continue
        if alpha[int(ord(a[j])) - 97] == 0:
            last = a[j]
            alpha[int(ord(a[j])) - 97] = 1
        else:
            result -= 1
            break
    alpha = [0] * 26
    result += 1

print(result)
