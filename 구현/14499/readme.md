## 주사위 굴리기 (14499)

### 솔루션

1. 주사위 굴리기
   동서남북 주사위를 굴릴때마다

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
