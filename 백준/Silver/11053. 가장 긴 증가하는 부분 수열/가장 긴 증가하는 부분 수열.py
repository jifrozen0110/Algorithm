import sys

input=sys.stdin.readline

def binarySearch(arr,target):
    left,right=0,len(arr)-1
    while (left<=right):
        mid=(left+right)//2
        if arr[mid]==target:
            return mid
        elif arr[mid]<target:
            left=mid+1
        else:
            right=mid-1

    return left

def lts(arr):
    lts_arr=[]
    for a in arr:
        pos=binarySearch(lts_arr,a)
        if pos==len(lts_arr):
            lts_arr.append(a)
        else:
            lts_arr[pos]=a
    return lts_arr

N=int(input())
A=list(map(int,input().strip().split()))

print(len(lts(A)))