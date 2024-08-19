import sys
from collections import deque

input=sys.stdin.readline
dx=[1,0,-1,0]
dy=[0,1,0,-1]

R,C=map(int,input().split())
arr=[list(input().rstrip()) for _ in range (R)]
q=deque([])
s=deque([])
start,end=0,0

for i in range (R):
    for j in range (C):
        if arr[i][j]=='*':
            q.append((i,j))

sec=0
isKa=False
while True:
    for i in range (R):
        for j in range (C):
            if arr[i][j]=='S':
                s.append((i,j))

    if not s:
        isKa=True
        break
    isCheck=False
    while s:
        x,y=s.popleft()
        arr[x][y]='.'
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=R or ny>=C:
                continue
            if arr[nx][ny]=='*' or arr[nx][ny]=='X':
                continue
            if arr[nx][ny]=='D':
                isCheck=True
                break;
            arr[nx][ny]='S'

        temp=[]
    while q:
        x,y=q.popleft()
        for i in range (4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=R or ny>=C:
                continue
            if arr[nx][ny]=='*' or arr[nx][ny]=='X' or arr[nx][ny]=='D':
                continue
            arr[nx][ny]='*'
            temp.append((nx,ny))
    q.extend(temp)


    sec+=1
    if isCheck:
        break;
if isKa:
    print("KAKTUS")
else:
    print(sec)

