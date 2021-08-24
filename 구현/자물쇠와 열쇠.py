# https://programmers.co.kr/learn/courses/30/lessons/60059

def rotate(key, d):
    n = len(key)
    array = [[0] * n for _ in range(n)]
    if d == 1:
        for i in range(n):
            for j in range(n):
                array[j][n - 1 - i] = key[i][j]
    elif d == 2:
        for i in range(n):
            for j in range(n):
                array[n - 1 - i][n - 1 - j] = key[i][j]
    elif d == 3:
        for i in range(n):
            for j in range(n):
                array[n - 1 - j][i] = key[i][j]
    else:
        for i in range(n):
            for j in range(n):
                array[i][j] = key[i][j]


def check(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    return True


def solution(key, lock):
    n = len(key)
    m = len(lock)
    new_lock = [[0] * (m * 3) for _ in range(m * 3)]
    for i in range(m):
        for j in range(m):
            new_lock[m + i][m + j] = lock[i][j]
    for i in range(1, m * 2):
        for j in range(1, m * 2):
            for d in range(4):
                new_key = rotate(key, d)
                for x in range(n):
                    for y in range(n):
                        new_lock[i + x][j + y] += new_key[x][y]
                if check(new_lock):
                    return True
                for x in range(n):
                    for y in range(n):
                        new_lock[i + x][j + y] -= new_key[x][y]
    return False


print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))