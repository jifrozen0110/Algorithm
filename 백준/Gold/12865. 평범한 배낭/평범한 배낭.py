import sys
input=sys.stdin.readline

N,K=map(int,input().split())

dp=[-1]*(K+1)
dp[0]=0
goods=[]

for _ in range (N):
    goods.append(list(map(int,input().split())))


for w,v in goods:
    for i in range (K,-1,-1):
        if dp[i]!=-1 and i+w<=K:
            dp[i+w]=max(dp[i+w],dp[i]+v)

print(max(dp))