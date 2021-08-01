from bisect import bisect
n=int(input())
data=list(map(int,input().split()))

dp=[data[0]]
for i in range (1,n):
    if data[i]>dp[-1]:
        dp.append(data[i])
    else:
        dp[bisect(dp,data[i])]=data[i]

print(n-len(dp))