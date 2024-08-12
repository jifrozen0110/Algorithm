import sys
input=sys.stdin.readline

N=int(input())

arr=list(map(int,input().split()))

M=int(input())

targets=list(map(int,input().split()))

arr.sort()

def binarySearch(target):
    left=0
    right=N-1

    while left<=right:
        mid=(left+right)//2

        if arr[mid]<target:
            left=mid+1
        elif(arr[mid]>target):
            right=mid-1
        else:
            return True
        if left>right:
            break;

    return False

for target in targets:
    if binarySearch(target):
        print(1)
    else:
        print(0)


