n, m = map(int, input().split())
a, b, d = map(int, input().split())

data = []
data1 = [[0] * m for i in range(n)]
for i in range(n):
    data.append(list(map(int, input().split())))
print(data1)
data1[a][b] = 1
# 북 동 남 서
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
result = 0


def turn(d):
    d -= 1
    if d < 0:
        d = 3
    return d


count = 1
while True:
    d = turn(d)

    if data[a + dx[d]][b + dy[d]] == 0 and data1[a + dx[d]][b + dy[d]] == 0:
        data1[a + dx[d]][b + dy[d]] = 1
        a = a + dx[d]
        b = b + dy[d]
        result += 1
        count = 1
    else:
        d = turn(d)
        count += 1
    if count == 3:
        if data[a - dx[d]][b - dy[d]] == 1:
            break
        data1[a - dx[d]][b - dy[d]] = 1
        a = a - dx[d]
        b = b - dy[d]
        result += 1
        count = 1
print(result)
