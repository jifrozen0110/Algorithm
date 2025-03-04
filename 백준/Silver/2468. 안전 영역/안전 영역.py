import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline
move=[[-1,0],[0,1],[1,0],[0,-1]]
N=int(input())
map=[list(map(int,input().strip().split())) for _ in range (N)]

# 이게 되네?
max_rain = max(max(row) for row in map)
min_rain = min(min(row) for row in map)
answer=1

def depthSearch(visited,x,y,limit):
    visited[x][y]=True
    for m in move:
        nx=x+m[0]
        ny=y+m[1]
        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        if map[nx][ny]<=limit:
            continue
        if visited[nx][ny]:
            continue
        depthSearch(visited,nx,ny,limit)

def searchSection(rain):
    visited=[[False] * N for _ in range (N)]
    cnt=0
    for i in range (N):
        for j in range (N):
            if not visited[i][j] and map[i][j] > rain:
                visited[i][j]=True
                depthSearch(visited,i,j,rain)
                cnt+=1
    return cnt

for i in range (min_rain,max_rain+1):
    answer=max(answer,searchSection(i))

print(answer)