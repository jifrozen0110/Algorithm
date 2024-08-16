
import heapq
import sys
input=sys.stdin.readline
heap=[]

N=int(input())

result=[]
for i in range (N):
    num=int(input())
    if num==0:
        if len(heap)==0:
            result.append(0)
        else:
            result.append(-heapq.heappop(heap))
    else:
        heapq.heappush(heap,-num)

print(*result,sep='\n')