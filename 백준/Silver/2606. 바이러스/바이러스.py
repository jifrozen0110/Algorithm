
import sys
input=sys.stdin.readline

N=int(input())
e=int(input())

graph=[[]*(N+1) for _ in range (N+1)]

for i in range (e):
    x,y=map(int,input().split())

    graph[x].append(y)
    graph[y].append(x)

visited=[False]*(N+1)

cnt=0
def DFS(start):
    global cnt
    visited[start]=True
    for i in graph[start]:
        if not visited[i]:
            cnt+=1
            DFS(i)

DFS(1)

print(cnt)
