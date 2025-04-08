import sys
input=sys.stdin.readline

N,M=map(int,input().split())

arr=[int(input()) for _ in range (N)]

targets=[tuple(map(int,input().split())) for _ in range (M)]

n=len(arr)
max_tree=[0]*(n*4)
min_tree=[1000000001]*(n*4)

def max_build(index,left,right):
    if left==right:
        max_tree[index] = arr[left]
        return arr[left]
    mid=(left+right)//2
    max_tree[index]=max(max_build(index*2,left,mid),max_build(index*2+1,mid+1,right))
    return max_tree[index]

def min_build(index,left,right):
    if left==right:
        min_tree[index] = arr[left]
        return arr[left]
    mid=(left+right)//2
    min_tree[index]=min(min_build(index*2,left,mid),min_build(index*2+1,mid+1,right))
    return min_tree[index]

def max_query(start,end,index,left,right):
    if end<left or start>right:
        return 0
    if left <= start and end <= right:
        return max_tree[index]
    mid=(start+end)//2
    return max(max_query(start,mid,index*2,left,right),max_query(mid+1,end,index*2+1,left,right))

def min_query(start,end,index,left,right):
    if end<left or start>right:
        return 1000000001
    if left <= start and end <= right:
        return min_tree[index]
    mid=(start+end)//2
    return min(min_query(start,mid,index*2,left,right),min_query(mid+1,end,index*2+1,left,right))


max_build(1,0,n-1)
min_build(1,0,n-1)

for i in range (M):
    start,end=targets[i]
    print(f'{min_query(0,n-1,1,start-1,end-1)} {max_query(0,n-1,1,start-1,end-1)}')
