import sys

input=sys.stdin.readline

M,N,L=map(int,input().split())
place=list(map(int,input().split()))
place.sort()
cords=[]
for i in range (N):
    x,y=map(int,input().split())
    cords.append([x,y])


def binarySearch(arr,target):
    left=0
    right=len(arr)-1
    rightAns=0
    leftAns=0
    while left<=right:
        mid=(left+right)//2
        if arr[mid]==target:
            return arr[mid]
        if arr[mid]<target:
            leftAns=arr[mid]
            left=mid+1
        elif arr[mid]>=target:
            rightAns=arr[mid]
            right=mid-1
    if abs(rightAns-target)>abs(leftAns-target):
        return leftAns
    else:
        return rightAns
cords.sort()
cnt=0
for i in range (N):
    x,y=cords[i]
    index=binarySearch(place,x)
    if abs(x-index)+y<=L:
        cnt+=1

print(cnt)




