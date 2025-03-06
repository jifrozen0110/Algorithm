from collections import deque

def bfs(x,y,info,dp):
    N,M=len(dp),len(dp[0])
    q=deque()
    q.append((x,y))
    
    for i in range(len(info)):
        n=len(q)
        for j in range (n):
            x,y=q.popleft()
            
            nx=x+info[i][0]
            if 0<=nx<N and dp[nx][y]!=i+1:
                dp[nx][y]=i+1
                q.append((nx,y))
            ny=y+info[i][1]
            if 0<=ny<M and dp[x][ny]!=i+1:
                dp[x][ny]=i+1
                q.append((x,ny))
def solution(info, n, m):
    N=len(info)
    dp=[[0]*m for _ in range (n)]
    
    bfs(0,0,info,dp)
    
    print(dp)
    for i in range(len(dp)):
        if dp[i].count(N)>0:
            return i
        
    return -1