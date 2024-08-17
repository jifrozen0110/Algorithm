

import sys
from collections import deque
sys.setrecursionlimit(200001)
input=sys.stdin.readline

T=int(input())

def DFS(start,color):
    visited[start]=color
    for i in arr[start]:
        if visited[i]==color:
            return False
        if visited[i]==-1:
            if not DFS(i,1 if color==2 else 2):
                return False
    return True



for _ in range(T):
    V,E=map(int,input().split())
    arr=[[] for _ in range (V+1)]
    visited=[-1] * (V+1)
    isBinary=True

    for j in range (E):
        x,y=map(int,input().split())
        arr[x].append(y)
        arr[y].append(x)

    for i in range(1,V+1):
        if visited[i]==-1:
            if not DFS(i,1):
                isBinary=False
                break

    if isBinary:
        print("YES")
    else:
        print("NO")