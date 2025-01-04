import sys
input=sys.stdin.readline

N=int(input())

A=list(map(int,input().split()))
answer=0
def dfs(cnt,sum,last,visited):
    global answer
    if cnt==N:
        answer=max(answer,sum)
        return
    for i in range (N):
        if not visited[i]:
            visited[i]=True
            dfs(cnt+1,sum+abs(last-A[i]),A[i],visited)
            visited[i]=False

visited=[False]*N
for i in range (N):
    if not visited[i]:
        visited[i]=True
        dfs(1,0,A[i],visited)
        visited[i]=False
print(answer)