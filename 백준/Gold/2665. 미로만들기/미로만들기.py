# 8
# 11100110
# 11010010
# 10011010
# 11101100
# 01000111
# 00110001
# 11011000
# 11000111

import sys
from collections import deque
input=sys.stdin.readline

n=int(input())

dx=[1,0,-1,0]
dy=[0,1,0,-1]
arr=[list(map(int,input().rstrip())) for _ in range (n)]
visited=[[False] * (n+1) for _ in range (n+1)]
q=deque([])

q.append((0,0))
visited[0][0]=0


def recurs(q,depth):
    temp=[]
    while q:
        x,y=q.popleft()

        for i in range (4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=n or visited[nx][ny]:
                continue
            if nx==n-1 and ny==n-1:
                print(depth)
                return
            visited[nx][ny]=True
            if arr[nx][ny]==1:
                q.append((nx,ny))
            else:
                temp.append((nx,ny))
    q.extend(temp)
    recurs(q,depth+1)


recurs(q,0)


