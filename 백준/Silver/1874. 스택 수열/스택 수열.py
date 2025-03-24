import sys
input=sys.stdin.readline

n=int(input())

index=0

arr=[int(input()) for _ in range (n)]

stack=[]
num=1
answer=[]
while (True):
    if len(arr)==index:
        break
    if len(stack)>0 and arr[index]==stack[-1]:
        answer.append("-")
        index+=1
        stack.pop()
    else:
        answer.append("+")
        stack.append(num)
        num+=1
        if num>n+1:
            answer.clear()
            answer.append("NO")
            break

print('\n'.join(map(str,answer)))