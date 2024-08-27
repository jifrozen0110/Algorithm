# 2 7
# 2 3 2 3 1 2 7
import sys
from collections import deque
input=sys.stdin.readline

N,K=map(int,input().split())

elecs=list(map(int,input().split()))

q=[]

total=0
index=0
for i in range (len(elecs)):
    if elecs[i] in q:
        continue
    if len(q)<N:
        q.append(elecs[i])
    else:
        last_used=-1
        temp=-1
        for j in range (len(q)):
            if q[j] not in elecs[i:]:
                temp=j
                break
            elif last_used<elecs[i:].index(q[j]):
                last_used=elecs[i:].index(q[j])
                temp=j


        q[temp]=elecs[i]
        total+=1

print(total)


