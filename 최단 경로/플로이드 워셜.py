INF=int(1e9)

n=int(input())
m=int(input())

graph=[[INF]*(n+1) for _ in range (n+1)]

for a in range (1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0

for k in range (1,n+1):
    for a in range (1,n+1):
        for b in range (1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

for a in range (1,n+1):
    for b in range(1,n+1):
        if graph[a][b]==INF:
            print("INF")
        else:
            print(graph[a][b])