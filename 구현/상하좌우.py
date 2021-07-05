n = int(input())

data = list(input().split())

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
dr = ['R', 'U', 'L', 'D']

x, y = 0, 0

for i in data:
    for j in range(len(dr)):
        if i == dr[j]:
            if x + dx[j] >= 0 and x + dx[j] < 5 and y + dy[j] >= 0 and y + dy[j] < 5:
                x += dx[j]
                y += dy[j]

print(x + 1, y + 1)
