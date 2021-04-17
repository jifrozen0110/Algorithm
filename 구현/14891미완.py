# https://www.acmicpc.net/problem/14891

def clock(clock, data, n):
    for i in range(n):
        if clock == '-1':
            if data[i][2] == data[i + 1][2]:
                for j in range(8):
                    data[i][j] = data[i][(j + 1) % 8]
            else:
                for j in range(8):
                    data[i][j] = data[i][(j + 1) % 8]
                    data[(i + 1) % n][(j + 1) % 8] = data[(i + 1) % n][j]
        elif clock == '1':
            if data[i][2] == data[i + 1][2]:
                for j in range(8):
                    data[i][(j + 1) % 8] = data[i][j]
            else:
                for j in range(8):
                    data[i][j + 1] = data[i][j]
                    data[(i + 1) % n][j] = data[(i + 1) % n][j + 1]


def clock_right(data, clock, start):
    if clock == -1:
        for j in range(8):
            data[start - 1][j] = data[start - 1][(j + 1) % 8]
        if start >= 4 or data[start - 1][2] == data[start][6]:
            return
        else:
            for i in range(start - 1, 4):
                for j in range(8):
                    data[i][(j + 1) % 8] = data[i][j]
    else:
        for j in range(8):
            data[start - 1][(j + 1) % 8] = data[start - 1][j]
        if start <= 1 or data[start - 1][2] == data[start-2][6]:
            return
        else:
            for i in range(start - 1, 4):
                for j in range(8):
                    data[i][j] = data[i][(j + 1) % 8]

def clock_left(data, clock, start):
    if clock == -1:
        for j in range(8):
            data[start - 1][j] = data[start - 1][(j + 1) % 8]
        if start <= 1 or data[start - 1][2] == data[start][6]:
            return
        else:
            for i in range(start - 1, 4):
                for j in range(8):
                    data[i][(j + 1) % 8] = data[i][j]
    else:
        for j in range(8):
            data[start - 1][(j + 1) % 8] = data[start - 1][j]
        if start >= 4 or data[start - 1][2] == data[start][6]:
            return
        else:
            for i in range(start - 1, 4):
                for j in range(8):
                    data[i][j] = data[i][(j + 1) % 8]


data = []
for i in range(4):
    data.append([input()])

n = int(input())
for i in range(n):
    start, clock = map(int, input().split())
