import sys
input=sys.stdin.readline

arr=[int(input()) for _ in range (9)]

target=sum(arr)-100

isCheck=False
for i in range (len(arr)):
    for j in range (i+1,len(arr)):
        if target==arr[i]+arr[j]:
            arr.remove(arr[j])
            arr.remove(arr[i])
            isCheck=True
            break
    if isCheck:
        break
arr.sort()

print(*arr,sep='\n')