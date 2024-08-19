import sys
from collections import deque
input=sys.stdin.readline

N,M,K,X=map(int,input().split())

arr=[[] for _ in range (N+1)]
visited=[False]*(N+1)
for i in range (M):
    a,b=map(int,input().split())
    arr[a].append(b)

q=deque([])
q.append((X,0))
visited[X]=True
result=[]
cnt=0
while q:
    now=q.popleft()
    if now[1]==K:
        result.append(now[0])
        continue
    for i in arr[now[0]]:
        if not visited[i]:
            visited[i]=True
            q.append((i,now[1]+1))

if len(result)>0:
    result.sort()
    print(*result,sep='\n')
else:
    print(-1)

