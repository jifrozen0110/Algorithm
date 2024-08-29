import sys
input=sys.stdin.readline

N=int(input())

arr=list(map(int,input().split()))

dp=[0]*(N+1)

for i in range (N):
    dp[i]=arr[i]
    for j in range (i):
        if arr[j]<arr[i]:
            dp[i]=max(dp[i],dp[j]+arr[i])

print(max(dp))