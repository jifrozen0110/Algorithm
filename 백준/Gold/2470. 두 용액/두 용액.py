import sys
input=sys.stdin.readline

N=int(input())

liquids=list(map(int,input().split()))

liquids.sort()

def binarySearch():
    minGap=2000000001
    a=0
    b=0
    start=0
    end=N-1

    while(start<end):
        gap=liquids[start]+liquids[end]
        if minGap>abs(gap):
            minGap=abs(gap)
            a=liquids[start]
            b=liquids[end]

        if gap<0:
            start+=1
        elif gap>0:
            end-=1
        else: break;

    print(f"{a} {b}")

if liquids[N-1]<0:
    print(f'{liquids[N-2]} {liquids[N-1]}')
elif liquids[0]>=0:
    print(f'{liquids[0]} {liquids[1]}')
else:
    binarySearch()

