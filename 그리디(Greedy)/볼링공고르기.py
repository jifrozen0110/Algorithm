n, m = map(int, input().split())
data = list(map(int, input().split()))
result = 0

for i in range(len(data)):
    for j in range(i, len(data)):
        if data[i] != data[j]:
            result += 1

print(result)
