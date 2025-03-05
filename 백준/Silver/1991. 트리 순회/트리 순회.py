import sys
from collections import defaultdict
input=sys.stdin.readline

N=int(input())

tree=defaultdict(list)
root=0
for i in range (N):
    parent, left, right=input().split()
    if i==0:
        root=parent
    tree[parent].append(left)
    tree[parent].append(right)


result=[]
def preorder(arr,target):
    arr.append(target)
    if tree[target][0]!='.':
        preorder(arr,tree[target][0])
    if tree[target][1]!='.':
        preorder(arr,tree[target][1])

def middleorder(arr,target):
    if tree[target][0]!='.':
        middleorder(arr,tree[target][0])
    arr.append(target)
    if tree[target][1]!='.':
        middleorder(arr,tree[target][1])


def postorder(arr,target):
    if tree[target][0]!='.':
        postorder(arr,tree[target][0])
    if tree[target][1]!='.':
        postorder(arr,tree[target][1])
    arr.append(target)
pre=[]
middle=[]
post=[]

preorder(pre,root)
middleorder(middle,root)
postorder(post,root)


print(*pre,sep='')
print(*middle,sep='')
print(*post,sep='')