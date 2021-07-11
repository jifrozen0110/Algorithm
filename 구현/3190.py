n = int(input())

# 동 남 서 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 회전해야하는 경우
def turn(direction, d):
    if direction == "D":
        if d == 3:
            d = 0
            return d
        d += 1
    else:
        if d == 0:
            d = 3
            return d
        d -= 1
    return d


data = [[0] * (n) for i in range(n)]
# 사과
m = int(input())
# 맵에 사과좌표 1로 바꿈
for i in range(m):
    a, b = map(int, input().split())
    data[a-1][b-1] = 1
# 시간 방향
L = int(input())
time = [0] * L
direction = [0] * L
for i in range(L):
    a, b = input().split()
    time[i] = int(a)
    direction[i] = b

d = 0
# 뱀의 현재좌표
snake = [(0,0)]
x, y = 0,0
result = 0
while True:
    result += 1
    x = dx[d] + x
    y = dy[d] + y
    # 지도 밖으로 넘어가지 않으면
    if 0 <= x < n and 0 <= y < n:
        #뱀 현재 머리 위치 다음좌표로
        snake.append((x, y))
        for i in snake[:-1]:#뱀머리위치 빼고 나머지 위치 비교
            if (x, y) == i:
                print(result)
                exit(0)
        #사과 없으면
        if data[x][y] == 0:
            snake.pop(0)#뱀 꼬리 움직임
        #사과 있으면
        if data[x][y] == 1:
            data[x][y] = 0#사과 먹음
    #맵밖으로 나가면
    else:
        print(result)
        exit(0)

    #시간마다 조사해 회전해야하면 함수 불러옴
    for j in range(len(time)):
        if result == time[j]:
            d = turn(direction[j], d)
            break

