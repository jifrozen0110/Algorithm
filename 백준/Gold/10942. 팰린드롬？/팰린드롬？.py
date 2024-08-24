import sys
input=sys.stdin.readline

N=int(input())
arr=list(map(int,input().split()))
M=int(input())

dp=[[False] * (N+1) for _ in range (N+1)]

for s in range(N):
    left=s
    right=s
    index=0
    while left>=0 and right<N and arr[left]==arr[right]:
        dp[left][right]=True
        left-=1
        right+=1

    left=s
    right=s+1
    while left>=0 and right<N and arr[left]==arr[right]:
        dp[left][right]=True
        left-=1
        right+=1



for i in range(M):
    S,E=map(int,input().split())
    print(1 if dp[S-1][E-1] else 0)

