import sys
import heapq

input=sys.stdin.readline

N=int(input())

lines=[]

for i in range(N):
    h,o=map(int,input().split())
    if h>o:
        h,o=o,h
    lines.append((h,o))

L=int(input())
lines.sort(key=lambda x: (x[1],x[0]))


heap=[]
cnt=0
maxVal=0
for i in range (len(lines)):
    if lines[i][1]-lines[i][0]>L:
        continue
    now=lines[i][1]-L
    while heap and heap[0][0]<now:
        heapq.heappop(heap)
        cnt-=1

    heapq.heappush(heap,lines[i])
    cnt+=1
    maxVal=max(maxVal,cnt)


print(maxVal)
