import sys

input=sys.stdin.readline

N=int(input())

arr=list(input().rstrip())
visited=[False]*(N+1)
graph=[[] for _ in range (N+1)]
total=0
for i in range (N-1):
    u,v=map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)
    if arr[u-1]=='1' and arr[v-1]=='1':
        total+=2

def DFS(start):
    visited[start]=True
    inside=0
    for i in graph[start]:
        if arr[i-1]=='1':
            inside+=1
        elif not visited[i] and arr[i-1]=='0':
            inside+=DFS(i)
    return inside


for i in range (1,N+1):
    if not visited[i] and arr[i-1]=='0':
        result=DFS(i)
        total+=result*(result-1)

print(total)



