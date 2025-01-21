import sys
sys.setrecursionlimit(10000)

dx=[-1,1,0,0]
dy=[0,0,-1,1]
def solution(maps):
    answer = []
    visited=[[False]*len(maps[0]) for _ in range (len(maps))]
    def dfs(maps,visited,x,y,value):
        for dx,dy in [(1,0), (0,1), (-1,0), (0,-1)]:
            nx=x+dx
            ny=y+dy
            if nx<0 or ny<0 or nx>=len(maps) or ny>=len(maps[0]):
                continue
            if visited[nx][ny]:
                continue

            if maps[nx][ny]=='X':
                continue
            visited[nx][ny]=True
            value+=dfs(maps,visited,nx,ny,int(maps[nx][ny]))
        return value
    for i in range (len(maps)):
        for j in range (len(maps[0])):
            if not visited[i][j] and maps[i][j]!='X':
                visited[i][j]=True
                answer.append(dfs(maps,visited,i,j,int(maps[i][j])))
    
    answer.sort()
    return answer if answer else [-1]


        
    