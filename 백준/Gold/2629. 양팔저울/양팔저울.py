import sys
sys.setrecursionlimit(10**8)
input=sys.stdin.readline

n=int(input())

chu=list(map(int,input().split()))

b=int(input())

balls=list(map(int,input().split()))
maxVal=500*n+1
dp=[[False] * (maxVal) for _ in range (n+1)]


def calc(index,left,right):
    diff=abs(left-right)
    if dp[index][diff]:
        return
    dp[index][diff]=True
    if index==n:
        return

    calc(index+1,left+chu[index],right)
    calc(index+1,left,right+chu[index])
    calc(index+1,left,right)



calc(0,0,0)
for ball in balls:
    if ball<maxVal and dp[n][ball]:
        print("Y",end=' ')
    else:
        print("N",end=' ')

print()