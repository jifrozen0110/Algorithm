import sys

input=sys.stdin.readline

S=input().rstrip()

dp=[[0]*len(S) for _ in range (len(S))]
dp[0][0]=1
total=0
cnt=0
N=len(S)
for s in range(N):
    left=s
    right=s
    index=0
    while left>=0 and right<N and S[left]==S[right]:
        dp[left][right]=True
        left-=1
        right+=1

    left=s
    right=s+1
    while left>=0 and right<N and S[left]==S[right]:
        dp[left][right]=True
        left-=1
        right+=1

min_cuts = [float('inf')] * N
for i in range (N):
    if dp[0][i]:
        min_cuts[i]=0
    else:
        for j in range (i):
            if dp[j+1][i]:
                min_cuts[i] = min(min_cuts[i], min_cuts[j] + 1)

print(min_cuts[-1]+1)