import sys
input=sys.stdin.readline

A=input().strip()
B=input().strip()

r=len(A)
c=len(B)

dp=[[0]*(c+1) for _ in range (r+1)]

for i in range (1,r+1):
    for j in range (1,c+1):
        if A[i-1]==B[j-1]:
            dp[i][j]=dp[i-1][j-1]+1
        else:
            dp[i][j]=max(dp[i-1][j],dp[i][j-1])

print(dp[r][c])