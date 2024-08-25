import sys

input=sys.stdin.readline

N,M=map(int,input().split())

arr=[]

for _ in range (N):
    arr.append(list(map(int,input().split())))

for i in range (1,M):
    arr[0][i]+=arr[0][i-1]

for i in range (1,N):
    left_dp=arr[i][:]
    right_dp=arr[i][:]

    for j in range (M):
        if j==0:
            left_dp[j]+=arr[i-1][j]
        else:
            left_dp[j]+=max(arr[i-1][j],left_dp[j-1])

    for j in range(M-1,-1,-1):
        if j==M-1:
            right_dp[j]+=arr[i-1][j]
        else:
            right_dp[j]+=max(arr[i-1][j],right_dp[j+1])

    for j in range (M):
        arr[i][j]=max(left_dp[j],right_dp[j])


print(arr[N-1][M-1])
