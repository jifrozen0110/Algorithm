import sys
import heapq
input=sys.stdin.readline

N=int(input())


arr=[]

for i in range (N):
    deadline, cnt=map(int,input().split())
    arr.append((deadline,cnt))

arr.sort()

heap=[]
for d,c in arr:
    heapq.heappush(heap,c)
    if d<len(heap):
        heapq.heappop(heap)

print(sum(heap))


