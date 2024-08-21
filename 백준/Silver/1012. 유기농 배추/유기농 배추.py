import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
T=int(input())

dx=[1,0,-1,0]
dy=[0,1,0,-1]
result=[]
def DFS(i,j):
    for d in range (4):
        nx=i+dx[d]
        ny=j+dy[d]
        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue
        if arr[nx][ny]==0 or visited[nx][ny]:
            continue
        visited[nx][ny]=True
        DFS(nx,ny)

for _ in range (T):
    M,N,K=map(int,input().split())

    arr=[[0] * (M) for _ in range (N)]
    visited=[[False] * (M) for _ in range (N)]

    for i in range (K):
        x,y=map(int,input().split())
        arr[y][x]=1
    cnt=0
    for i in range (N):
        for j in range (M):
            if not visited[i][j] and arr[i][j]==1:
                cnt+=1
                visited[i][j]=True
                DFS(i,j)
    result.append(cnt)

print(*result,sep='\n')