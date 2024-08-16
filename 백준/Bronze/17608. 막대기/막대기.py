import sys
input=sys.stdin.readline

N=int(input())
stack=[]

while N>0:
    num=int(input())
    N-=1
    while len(stack)>0 and stack[-1]<=num:
        stack.pop()
    stack.append(num)

print(len(stack))
