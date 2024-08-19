import sys
from collections import deque
input=sys.stdin.readline

N=int(input())
M=int(input())

indegree=[0]*(N+1)
graph=[[] for _ in range (N+1)]
count=[0]*(N+1)
basic=[0]*(N+1)
count[N]=1
q=deque()
for i in range (M):
    X,Y,K=map(int,input().split())
    graph[X].append([Y,K])
    basic[X]=1
    indegree[Y]+=1
for i in range (1,N+1):
    if indegree[i]==0:
        q.append(i)

while q:
    now=q.popleft()
    for y,cost in graph[now]:
        indegree[y]-=1
        count[y]+=count[now]*cost
        if indegree[y]==0:
            q.append(y)

for i in range (1,N+1):
    if basic[i]==0:
        print(f"{i} {count[i]}")