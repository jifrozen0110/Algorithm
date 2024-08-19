import sys
from collections import deque

input=sys.stdin.readline

N,M=map(int,input().split())

indegree=[0]*(N+1)
graph=[[] for _ in range (N+1)]
q=deque()
result=[]
for _ in range(M):
    a,b=map(int,input().split())
    indegree[b]+=1
    graph[a].append(b)

for i in range (1,N+1):
    if indegree[i]==0:
        q.append(i)

while q:
    now=q.popleft()
    result.append(now)
    for i in graph[now]:
        indegree[i]-=1
        if indegree[i]==0:
            q.append(i)

print(*result)

