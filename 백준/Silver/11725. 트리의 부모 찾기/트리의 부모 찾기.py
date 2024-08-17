import sys
from collections import deque
input=sys.stdin.readline

N=int(input())
graph=[[]*(N+1) for _ in range (N+1)]

for i in range (N-1):
    x,y=map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

visited=[0]*(N+1)
q=deque([1])
visited[1]=-1

while q:
    now=q.popleft()
    for i in graph[now]:
        if visited[i]==0:
            visited[i]=now
            q.append(i)

print(*visited[2:],sep='\n')
