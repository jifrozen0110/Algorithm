import sys
input=sys.stdin.readline

N,M=map(int,input().split())

balls=[[]*N for _ in range (N)]

small=[0]*N
big=[0]*N
indegree=[0]*N
for i in range (M):
    a,b=map(int,input().split())
    balls[a-1].append(b-1)
def DFS(start,cur):
    visited[start]=True
    for i in balls[start]:
        if not visited[i]:
            small[cur]+=1
            big[i]+=1
            DFS(i,cur)


for i in range (N):
    visited=[False]*N
    DFS(i,i)


half=N//2
cnt=0
for i in range (N):
    if half<small[i] or half<big[i]:
        cnt+=1
print(cnt)

