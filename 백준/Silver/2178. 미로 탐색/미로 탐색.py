import sys
from collections import deque
input=sys.stdin.readline

N,M=map(int,input().split())

dx=[1,0,-1,0]
dy=[0,-1,0,1]
arr=[list(map(int,input().rstrip())) for _ in range (N)]

q=deque([])

q.append((0,0))

while q:
    now=q.popleft()
    for i in range(4):
        nx=now[0]+dx[i]
        ny=now[1]+dy[i]
        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue
        if arr[nx][ny]==1:
            arr[nx][ny]=arr[nx][ny]+arr[now[0]][now[1]]
            q.append((nx,ny))

print(arr[N-1][M-1])


