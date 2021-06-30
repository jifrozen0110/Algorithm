n = int(input())
data = list(map(int, input().split()))
data.sort()
a = 1

for x in data:
    if a < x:
        break
    a += x

print(a)
