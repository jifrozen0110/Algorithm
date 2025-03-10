import sys
input=sys.stdin.readline

N,C=map(int,input().split())
arr=[int(input()) for _ in range (N)]

answer=0
arr.sort()

left=0
right=arr[-1]-arr[0]
def installWifi(distance):
    wifiCnt=1
    start=arr[0]
    for i in range (1,len(arr)):
        if arr[i]-start>=distance:
            wifiCnt+=1
            start=arr[i]
    return wifiCnt

while (left<=right):

    mid=(right+left)//2
    if installWifi(mid)>=C:
        left=mid+1
        answer=max(answer,mid)
    else:
        right=mid-1


print(answer)

