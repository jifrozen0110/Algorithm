import sys
import heapq
input=sys.stdin.readline

N=int(input())
M=int(input())

arr=[[100001] * (N+1) for _ in range (N+1)]
visited=[False]*(N+1)
for i in range (M):
    x,y,cost=map(int,input().split())
    arr[x][y]=min(cost,arr[x][y])

start,end=map(int,input().split())
heap=[]
heapq.heappush(heap,(0,start))


minCost=float('inf')
while heap:
    now=heapq.heappop(heap)
    if visited[now[1]]:
        continue
    visited[now[1]]=True
    if now[1]==end:
        minCost=min(minCost,now[0])
        continue
    for i in range (1,N+1):
        if arr[now[1]][i]!=100001 and not visited[i]:
            heapq.heappush(heap,(now[0]+arr[now[1]][i],i))


print(minCost)

