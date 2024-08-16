# 3
# 10
# 20
# 40
import heapq
import sys
input=sys.stdin.readline

N=int(input())

h=[]
sum=0
for i in range (N):
    num=int(input())
    heapq.heappush(h,num)

while len(h)>1:
    num1=heapq.heappop(h)
    num2=heapq.heappop(h)
    sum+=(num1+num2)
    heapq.heappush(h,num1+num2)

print(sum)

