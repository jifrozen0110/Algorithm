import sys
import heapq
input=sys.stdin.readline

N,M=map(int,input().split())
dx=[1,0,-1,0]
dy=[0,1,0,-1]

arr=[input().rstrip() for _ in range (M)]
visited=[[False]*N for _ in range (M)]
heap=[]

heapq.heappush(heap,(0,0,0))
visited[0][0]=True

while heap:
    cost,x,y=heapq.heappop(heap)
    if x==N-1 and y==M-1:
        print(cost)
        break;
    for d in range(4):
        nx=x+dx[d]
        ny=y+dy[d]
        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue;
        if visited[ny][nx]:
            continue
        visited[ny][nx]=True
        heapq.heappush(heap,(cost+int(arr[ny][nx]),nx,ny))

