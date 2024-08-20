import sys
input=sys.stdin.readline
result=[]
while True:
    max_result=0
    arr=list(map(int,input().split()))
    arr.append(0)
    if arr[0]==0:
        break;
    stack=[]
    for index, value in enumerate(arr[1:]):
        temp=index
        while stack and stack[-1][1]>=value:
            cur=stack.pop()
            max_result=max(max_result,(index-cur[0])*cur[1])
            temp=cur[0]
        stack.append((temp,value))
    result.append(max_result)

print(*result,sep='\n')
