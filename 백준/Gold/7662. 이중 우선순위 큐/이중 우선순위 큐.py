import sys
import heapq
input=sys.stdin.readline

T=int(input())
result=[]

for _ in range (T):
    k=int(input())
    total=0
    max_heap=[]
    min_heap=[]
    numbers=set()
    for j in range (k):
        command, num=input().split()
        num=int(num)
        if command=='I':
            total+=1
            heapq.heappush(min_heap,(num,j))
            heapq.heappush(max_heap,(-num,j))
        else:
            if total<=0:
                continue
            if num==1:
                while max_heap and max_heap[0][1] in numbers:
                    heapq.heappop(max_heap)
                if max_heap:
                    numbers.add(heapq.heappop(max_heap)[1])
            else:
                while min_heap and min_heap[0][1] in numbers:
                    heapq.heappop(min_heap)
                if min_heap:
                    numbers.add(heapq.heappop(min_heap)[1])
            total-=1

    if total<=0:
        result.append("EMPTY")
    else:
        while max_heap and max_heap[0][1] in numbers:
            heapq.heappop(max_heap)
        while min_heap and min_heap[0][1] in numbers:
            heapq.heappop(min_heap)
        if min_heap:
            min_val=heapq.heappop(min_heap)[0]
        if max_heap:
            max_val=-heapq.heappop(max_heap)[0]

        result.append(f"{max_val} {min_val}")

print(*result, sep='\n')
