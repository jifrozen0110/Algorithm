# https://www.acmicpc.net/problem/11724

n,m=map(int,input().split())
data=[[0]* n for _ in range(n)]
visited=[0]* n
for i in range (m):
    a,b=map(int,input().split())
    data[a-1][b-1]=1
    data[b-1][a-1]=1


def dfs(v):
    visited[v]=1
    for i in range (n):
        if data[v][i]==1 and visited[i]==0:
            dfs(i)

count=0
for i in range (n):
    if visited[i] == 0:
        dfs(i)
        count+=1

print(count)





