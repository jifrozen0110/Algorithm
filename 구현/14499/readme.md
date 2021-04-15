## 주사위 굴리기 (14499)

### 솔루션

1. 주사위 굴리기 ( 이걸 생각하는게 좀 걸렸다)

주사위 위치는 고정하고 굴릴때마다 값만 이동시킨다 dice[3] 무조건 바닥 dice[1]이 무조건 top

   동서남북 주사위를 굴릴때마다 모든칸이 이동되는건 아니다.
![image](https://user-images.githubusercontent.com/62784314/114826707-c8262b80-9e02-11eb-840f-acdc1ec5fd21.png)
이동되는 칸만 골라 인덱스를 바꿔준다.

2. 좌표 이동시키면서 범위 확인

동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4

dx=[0,0,-1,1]
dy=[1,-1,0,0]

먼저 좌표를 이동하고 범위를 확인해야한다👍

3. 바닥이 0인경우와 d

https://www.acmicpc.net/problem/14499

```python
# https://www.acmicpc.net/problem/14499

n,m,x,y,k=map(int,input().split())
road=[list(map(int,input().split())) for _ in range (n)]
commands=list(map(int,input().split()))

dx=[0,0,-1,1]
dy=[1,-1,0,0]

dice=[0]*6

for command in commands:
    x = x + dx[command - 1]
    y = y + dy[command - 1]
    if (0 <= x < n) and (0 <=y < m):
        if command==1:# 동
            dice[1],dice[3],dice[4],dice[5]=dice[4],dice[5],dice[3],dice[1]
            if road[x][y]!=0:
                dice[3]=road[x][y]
                road[x][y]=0
            else:
                road[x][y]=dice[3]
            print(dice[1])
        elif command==2:# 서
            dice[1],dice[3],dice[4],dice[5]=dice[5],dice[4],dice[1],dice[3]
            if road[x][y]!=0:
                dice[3]=road[x][y]
                road[x][y]=0
            else:
                road[x][y]=dice[3]
            print(dice[1])
        elif command==3:# 북
            dice[0],dice[1],dice[2],dice[3]=dice[1],dice[2],dice[3],dice[0]
            if road[x][y]!=0:
                dice[3]=road[x][y]
                road[x][y]=0
            else:
                road[x][y]=dice[3]
            print(dice[1])
        elif command==4:# 남
            dice[0],dice[1],dice[2],dice[3]=dice[3],dice[0],dice[1],dice[2]
            if road[x][y]!=0:
                dice[3]=road[x][y]
                road[x][y]=0
            else:
                road[x][y]=dice[3]
            print(dice[1])
    else:
        x = x - dx[command - 1]
        y = y - dy[command - 1]
        continue







```
