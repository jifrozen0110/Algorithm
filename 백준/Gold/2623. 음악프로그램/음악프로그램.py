import sys
from collections import deque
input=sys.stdin.readline

N,M=map(int,input().split())

indegree=[0]*(N+1)
visited=[False]*(N+1)
graph=[[] for _ in range (  N+1)]
for _ in range (M):
    arr=list(map(int,input().split()))
    num=arr[1]
    for j in arr[2:]:
        graph[num].append(j)
        num=j
        indegree[j]+=1

q=deque([])

for i in range (1,N+1):
    if indegree[i]==0:
        q.append(i)
result=[]

while q:
    now=q.popleft()
    visited[now]=True
    result.append(now)
    for i in graph[now]:
        if not visited[i]:
            indegree[i]-=1
            if indegree[i]==0:
                q.append(i)

if len(result)!=N:
    print(0)
else:
    print(*result,sep='\n')

