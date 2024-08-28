# 10
# 10 -4 3 1 5 6 -35 12 21 -1

import sys
input=sys.stdin.readline

n=int(input())
arr=list(map(int,input().split()))

maxVal=-1000*100001

dp=[0]*n

for i in range (n):
    dp[i]=arr[i]

for i in range (1,n):
    dp[i]=max(dp[i],dp[i-1]+dp[i])


for i in range (n):
    maxVal=max(dp[i],maxVal)

print(maxVal)