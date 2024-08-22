import sys
input=sys.stdin.readline

T=int(input())
result=[]
for _ in range (T):
    N=int(input())
    coins=list(map(int,input().split()))
    M=int(input())
    dp=[0]*(M+1)
    dp[0]=1
    for coin in coins:
        for i in range (M+1):
            if i>=coin:
                dp[i]+=dp[i-coin]
    result.append(dp[M])

print(*result,sep='\n')