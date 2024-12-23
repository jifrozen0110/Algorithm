import sys

input=sys.stdin.readline

N,X=map(int,input().split())

arr=list(map(int,input().split()))
answer=[]
for num in arr:
    if X>num:
        answer.append(num)

print(*answer,sep=' ')