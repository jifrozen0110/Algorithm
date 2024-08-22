import sys

input=sys.stdin.readline

T=int(input())
k=int(input())

coins=[]

for _ in range (k):
    p,n=map(int,input().split())
    coins.append((p,n))

dp=[0]*(T+1)
dp[0]=1
for coin,cnt in coins:
    for money in range (T,0,-1):
        for c in range (1,cnt+1):
            if money >= coin * c:
                dp[money]+=dp[money-coin*c]


print(dp[T])