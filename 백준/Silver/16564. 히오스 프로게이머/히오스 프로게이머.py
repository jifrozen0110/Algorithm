# 3 10
# 10
# 20
# 15

import sys
input=sys.stdin.readline

N,K=map(int,input().split())

arr=[int(input()) for _ in range (N)]

arr.sort()

start=arr[0]
end=arr[N-1]+K
answer=0
while start<=end:
    mid=(start+end)//2
    sum=0
    for i in range (N):
        if mid>arr[i]:
            sum+=mid-arr[i]
    if sum>K:
        end=mid-1
    else:
        answer=mid
        start=mid+1


print(answer)