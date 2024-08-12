import sys
input=sys.stdin.readline

N,M=map(int,input().split())

trees=list(map(int,input().split()))

trees.sort()

left=0
right=1000000000
answer=0

def cutTree(zone):
    sum=0
    for tree in trees:
        if zone<tree:
            sum+=tree-zone
    return sum

while left<=right:
    mid=(left+right)//2
    sumVal=cutTree(mid)
    if sumVal==M:
        answer=mid
        break;
    elif sumVal>M:
        answer=mid
        left=mid+1
    elif sumVal<M:
        right=mid-1
    if left>right:
        break


print(answer)