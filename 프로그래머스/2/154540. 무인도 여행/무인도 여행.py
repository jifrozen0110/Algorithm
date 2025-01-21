from collections import deque
def solution(maps):
    answer = []
    visited=[[False]*len(maps[0]) for _ in range (len(maps))]
    
    for i in range (len(maps)):
        for j in range (len(maps[0])):
            if maps[i][j]=='X' or visited[i][j]:
                continue
            
            q=deque()
            q.append((i,j))
            visited[i][j]=True
            value=int(maps[i][j])
            while q:
                x,y=q.popleft()
                for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
                    nx=x+dx
                    ny=y+dy
                    if nx<0 or ny<0 or nx>=len(maps) or ny>=len(maps[0]):
                        continue
                    if maps[nx][ny]=='X' or visited[nx][ny]:
                        continue
                    visited[nx][ny]=True
                    value+=int(maps[nx][ny])
                    q.append((nx,ny))
            answer.append(value)
    answer.sort()
    return answer if answer else [-1]


        
    