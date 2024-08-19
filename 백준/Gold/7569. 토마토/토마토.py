import sys
from collections import deque
input=sys.stdin.readline

M,N,H=map(int,input().split())

arr=[[list(map(int,input().split())) for _ in range(N)] for _ in range (H)]
dx=[1,0,-1,0,0,0]
dy=[0,1,0,-1,0,0]
dz=[0,0,0,0,-1,1]

q=deque([])
for i in range (H):
    for j in range (N):
        for k in range (M):
            if arr[i][j][k]==1:
                q.append((k,j,i,0))
def checkTomato():
    for i in range (H):
        for j in range (N):
            for k in range (M):
                if arr[i][j][k]==0:
                    return False
    return True
def process():
    day=0
    while q:
        x,y,h,day=q.popleft()
        for i in range(6):
            nx=x+dx[i]
            ny=y+dy[i]
            nh=h+dz[i]

            if nx<0 or ny<0 or nx>=M or ny>=N or nh<0 or nh>=H or arr[nh][ny][nx]==1 or arr[nh][ny][nx]==-1:
                continue

            arr[nh][ny][nx]=1
            q.append((nx,ny,nh,day+1))

    return day


day=process()


print (day if checkTomato() else -1)



