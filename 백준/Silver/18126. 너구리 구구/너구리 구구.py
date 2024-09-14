import sys
from collections import deque
input=sys.stdin.readline

N=int(input())

rooms=[[] for _ in range (N+1)]
visited=[False for _ in range (N+1)]

for _ in range (N-1):
    A,B,C=map(int,input().split())
    rooms[A].append((B,C))
    rooms[B].append((A,C))

start=1

maxDist=0
q=deque([])
q.append((start,0));
visited[start]=True

while q:
    s,dist=q.popleft()
    maxDist=max(maxDist,dist)
    for i,d in rooms[s]:
        if visited[i]:
            continue
        visited[i]=True
        q.append((i,dist+d))

print(maxDist)
