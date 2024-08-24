import sys
input=sys.stdin.readline

S=input().rstrip()
A=int(input())
arr=[input().rstrip() for _ in range (A)]

dp=[False]*(len(S)+1)
dp[0]=True

for i in range (1,len(S)+1):
    for j in range (len(arr)):
        if i>=len(arr[j]) and dp[i-len(arr[j])]:
            if S[i-len(arr[j]):i]==arr[j]:
                dp[i]=dp[i-len(arr[j])]

if dp[len(S)]:
    print(1)
else:
    print(0)