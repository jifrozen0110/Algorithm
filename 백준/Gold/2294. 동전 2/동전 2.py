import sys
import heapq
input=sys.stdin.readline

n,k=map(int,input().split())

heap=[]
coins=[int(input()) for _ in range (n)]
visited=[False]*(k+1)
heapq.heappush(heap,(0,k))
result=-1
while heap:
    cnt,now=heapq.heappop(heap)
    if now==0:
        result=cnt
        break;
    for coin in coins:
        val=now-coin
        if val>=0 and not visited[val]:
            visited[val]=True
            heapq.heappush(heap,(cnt+1,val))

print(result)

