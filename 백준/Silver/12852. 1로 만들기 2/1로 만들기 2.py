import sys
input=sys.stdin.readline

n=int(input())

dp=[1e6]*(n+1)
result=[]
dp[0]=0
dp[1]=0
for i in range (2,n+1):
    dp[i]=dp[i-1]+1
    if i%3==0:
        dp[i]=min(dp[i//3]+1,dp[i])
    if i%2==0:
        dp[i]=min(dp[i//2]+1,dp[i])

target=n
while True:
    result.append(target)
    if target==1:
        break
    if dp[target-1]+1==dp[target]:
        target=target-1
        continue
    if target%3==0 and dp[target//3]+1==dp[target]:
        target=target//3
        continue
    if target%2==0 and dp[target//2]+1==dp[target]:
        target=target//2
print(dp[n])
print(*result)
