from collections import deque
import sys

input=sys.stdin.readline

N,K=map(int,input().split())

q=deque([i for i in range (1,N+1)])
result=[]
index=0
while q:
    index+=1
    if index==K:
        result.append(q.popleft())
        index=0
    else:
        q.append(q.popleft())

print("<",end='')
print(*result,sep=', ',end='')
print(">",end='')
print()
