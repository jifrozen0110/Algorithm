# https://www.acmicpc.net/problem/1260
# https://www.acmicpc.net/problem/1260
from collections import deque

n,m,v=map(int,input().split())
visited=[0] * (n+1)
data=[[0] * (n+1) for i in range (n+1)]
for i in range(m):
    a,b=map(int,input().split())
    data[a][b]=1
    data[b][a]=1

def dfs(v):
    visited[v]=1
    print(v,end=' ')
    for i in range (1,n+1):
        if visited[i]==0 and data[v][i]==1:
            dfs(i)

def bfs(v):
    visited[v]=0
    queue=deque([v])
    while queue:
        v=queue.popleft();
        print(v, end=' ')
        for i in range(1,n+1):
            if visited[i] == 1 and data[v][i] == 1:
                queue.append(i)
                visited[i] = 0


dfs(v)
print()
bfs(v)