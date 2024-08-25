import sys
input=sys.stdin.readline

N,K=map(int,input().split())

dp=[0]*(K+1)

goods=[]

for _ in range (N):
    goods.append(list(map(int,input().split())))


for w,v in goods:
    for i in range (K,-1,-1):
        if i-w>=0:
            dp[i]=max(dp[i],dp[i-w]+v)

print(dp[K])