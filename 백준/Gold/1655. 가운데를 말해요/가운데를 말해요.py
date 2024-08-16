import sys
import heapq
input=sys.stdin.readline

N=int(input())

max_heap=[]
min_heap=[]

cnt=0
mid=0

result=[]
for i in range (N):
    num=int(input())
    if len(max_heap)<=len(min_heap):
        heapq.heappush(max_heap,-num)
    else:
        heapq.heappush(min_heap,num)

    if min_heap and min_heap[0]<-max_heap[0]:
        left=-heapq.heappop(max_heap)
        right=heapq.heappop(min_heap)
        heapq.heappush(max_heap,-right)
        heapq.heappush(min_heap,left)
    result.append(-max_heap[0])

print(*result,sep='\n')


