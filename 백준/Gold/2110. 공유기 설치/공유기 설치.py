import sys
input=sys.stdin.readline

N,C=map(int,input().split())
wifis=[int(input()) for _ in range (N)]
wifis.sort()

left=1
right=wifis[N-1]
answer=0
while left<=right:
    mid=(left+right)//2

    start=wifis[0]
    cnt=1
    for i in range (1,len(wifis)):
        dist=wifis[i]-start
        if dist>=mid:
            start=wifis[i]
            cnt+=1
    if cnt>=C:
        answer=max(answer,mid)
        left=mid+1
    else:
        right=mid-1

print(answer)



