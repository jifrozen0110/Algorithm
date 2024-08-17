import sys
input=sys.stdin.readline

N,M=map(int,input().split())

graph=[[] * (N+1) for _ in range (N+1)]
for i in range (M):
    u,v=map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

visited=[False]*(N+1)
def DFS(start):
    if not visited[start]:
        visited[start]=True
        for i in graph[start]:
            if not visited[i]:
                DFS(i)

answer=0
for i in range (1,N+1):
    if not visited[i]:
        answer+=1
        DFS(i)


print(answer)



