import sys
from collections import deque
input=sys.stdin.readline

n=int(input())
m=int(input())

arr=[[] for _ in range (n)]
indegree=[0]*(n)
cost=[0]*(n)
city=[[] for _ in range (n)]

for i in range (m):
    x,y,c=map(int,input().split())
    arr[x-1].append((y-1,c))
    indegree[y-1]+=1
start,end=map(int,input().split())

q=deque([])


q.append((start-1))

while q:
    now=q.popleft()
    for y,c in arr[now]:

        if cost[y]<cost[now]+c:
            cost[y]=cost[now]+c
            city[y]=[now]
        elif cost[y]==cost[now]+c:
            city[y].append(now)
        indegree[y]-=1
        if indegree[y]==0:
            q.append(y)

q=deque([end-1])
route=set()
while q:
    now=q.popleft()
    for i in city[now]:
        if (now,i) not in route:
            route.add((now,i))
            q.append(i)

print(cost[end-1])
print(len(route))
