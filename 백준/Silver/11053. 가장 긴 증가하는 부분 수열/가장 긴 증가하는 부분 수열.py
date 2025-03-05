import sys

input=sys.stdin.readline

N=int(input())

arr=list(map(int,input().strip().split()))

dp=[1]*N

for i in range (len(arr)):
    for j in range (i-1,-1,-1):
        if arr[i]>arr[j]:
            dp[i]=max(dp[i],dp[j]+1)

print(max(dp))