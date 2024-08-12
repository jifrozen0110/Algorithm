import sys
input=sys.stdin.readline
N,B=map(int,input().split())

arr=[list(map(int,input().split())) for _ in range(N)]


def calcArr(startArr, endArr):
    newArr=[[0] * N for _ in range(N)]
    for i in range (N):
        for j in range (N):
            sum=0
            for k in range (N):
                sum+=(startArr[i][k]%1000*endArr[k][j]%1000)%1000
            newArr[i][j]=sum%1000
    return newArr



b=bin(B)[2:][::-1]

results=[arr]

for i in range (1,len(b)):
    results.append(calcArr(results[i-1],results[i-1]))

answer=[[0] * N for _ in range (N)]
for i in range(N):
    answer[i][i]=1

for i in range(len(b)):
    if b[i]=='1':
        answer=calcArr(results[i],answer)

for i in range (N):
    print(*answer[i])

