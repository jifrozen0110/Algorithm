# 5
# 6 9 5 7 4
import sys
input=sys.stdin.readline

N=int(input())
top=list(map(int,input().split()))
result=[0]
stack=[]
stack.append(0)
for i in range (1,N):
    current=top[i]
    index=i
    while stack and top[stack[-1]]<current:
        stack.pop()

    if len(stack)==0:
        result.append(0)
    else:
        result.append(stack[-1]+1)
    stack.append(i)

print(*result)