import sys
import heapq
input=sys.stdin.readline

N=int(input())
minCost=100001
cost=[0]*(N+1)
heap=[]

for i in range (1,N+1):
    cost[i]=int(input())
    heapq.heappush(heap,(cost[i],i))

graph=[[] for _ in range (N+1)]

minIndex=0
minVal=100001
for i in range (1,N+1):
    costs=list(map(int,input().split()))
    for j in range (len(costs)):
        num=costs[j]
        if num==0:
            continue
        if minVal>num:
            minIndex=j+1
            minVal=num
        graph[i].append((j+1,num))

visited=[False]*(N+1)
total=0
while heap:
    c,now=heapq.heappop(heap)
    if visited[now]:
        continue
    total+=c
    visited[now]=True
    for i,c in graph[now]:
        if not visited[i]:
            heapq.heappush(heap,(c,i))

val=total
val2=sum(cost)
print(val if val<val2 else val2)