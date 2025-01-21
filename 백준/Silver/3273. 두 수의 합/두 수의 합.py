n=int(input())

arr=list(map(int,input().split()))
x=int(input())

arr.sort()

start=0
end=len(arr)-1
answer=0
while (start<end):
    if arr[start]+arr[end]<x:
        start+=1
    elif arr[start]+arr[end]>x:
        end-=1
    else:
        answer+=1
        start+=1
print(answer)