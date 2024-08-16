import sys

input=sys.stdin.readline

N,K=map(int,input().split())

numbers=input().rstrip()

stack=[]

for num in numbers:
    while stack and K>0 and stack[-1]<int(num):
        stack.pop()
        K-=1
    stack.append(int(num))

if K>0:
    stack=stack[:-K]


print(*stack,sep='')