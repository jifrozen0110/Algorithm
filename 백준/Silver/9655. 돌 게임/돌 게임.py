import sys

input=sys.stdin.readline

N=int(input())

dp=[None]*(N+1)

dp[N]=True
for i in range (N,0,-1):
    if dp[i-1]==None:
        dp[i-1]=not dp[i]
    if dp[i-3]==None:
        dp[i-3]=not dp[i]

print('SK' if dp[1] else 'CY')