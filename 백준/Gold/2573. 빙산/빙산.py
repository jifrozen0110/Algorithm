import sys
input=sys.stdin.readline
from collections import deque
sys.setrecursionlimit(10**6)
N,M=map(int,input().split())
dx=[1,0,-1,0]
dy=[0,1,0,-1]
arr=[list(map(int,input().split())) for _ in range (N)]


def BFS(x,y):
    q=deque([])
    q.append((x,y))
    visited[x][y]=True
    melt=[]
    while q:
        x,y=q.popleft()
        cnt=0
        for i in range (4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=N or ny>=M:
                continue
            if arr[nx][ny]==0:
                cnt+=1
            elif not visited[nx][ny] and arr[nx][ny]>0:
                visited[nx][ny]=True
                q.append((nx,ny))
        if cnt>0:
            melt.append((x,y,cnt))
    for x,y,cnt in melt:
        arr[x][y]=max(0,arr[x][y]-cnt)


sec=0

while True:
    visited=[[False]*M for _ in range (N)]
    cnt=0
    for i in range (N):
        for j in range (M):
            if not visited[i][j] and arr[i][j]>0:
                cnt+=1
                BFS(i,j)

    if cnt>1:
        break
    if cnt==0:
        sec=0
        break
    sec+=1


print(sec)

