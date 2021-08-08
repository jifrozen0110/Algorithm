n = int(input())

data = [list(map(int, input().split())) for _ in range(n)]

for j in range(1, len(data)):
    data[j][0] = data[j][0] + min(data[j - 1][1], data[j - 1][2])
    data[j][1] = data[j][1] + min(data[j - 1][0], data[j - 1][2])
    data[j][2] = data[j][2] + min(data[j - 1][1], data[j - 1][0])

print(min(data[n - 1][0], data[n - 1][1], data[n - 1][2]))
