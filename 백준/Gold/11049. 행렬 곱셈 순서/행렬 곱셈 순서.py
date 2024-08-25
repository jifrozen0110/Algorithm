import sys

input=sys.stdin.readline

N=int(input())

arr=[(input().split()) for _ in range (N)]

dp=[[float('inf')]*(N) for _ in range (N)]
for i in range (len(arr)):
    dp[i][i]=0

for length in range (2,N+1):
    for i in range (N-length+1):
        j=i+length-1
        for k in range (i,j):
            dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j]+int(arr[i][0])*int(arr[k][1])*int(arr[j][1]))


print(dp[0][N-1])
