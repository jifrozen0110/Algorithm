import sys
sys.setrecursionlimit(10**8)
input=sys.stdin.readline

N=int(input())

dx=[1,0,-1,0]
dy=[0,1,0,-1]

arr=[input().rstrip() for _ in range (N)]
visited=[[False]*N for _ in range (N)]
result=[]
cnt=0


def DFS(i,j):
    global danji
    for d in range (4):
        nx=i+dx[d]
        ny=j+dy[d]
        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        if arr[nx][ny]=='0' or visited[nx][ny]:
            continue
        visited[nx][ny]=True
        danji+=1
        DFS(nx,ny)

for i in range (N):
    for j in range (N):
        if not visited[i][j] and arr[i][j]=='1':
            danji=1
            visited[i][j]=True
            cnt+=1
            DFS(i,j)
            result.append(danji)

result.sort()
print(cnt)
print(*result,sep='\n')