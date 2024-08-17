import sys
input=sys.stdin.readline

# 3 3
# 1 2 1
# 2 3 2
# 1 3 3

V,E=map(int,input().split())

parents=[0]*(V+1)

for i in range (1,V+1):
    parents[i]=i

edges=[]
for i in range (E):
    A,B,C=map(int,input().split())
    edges.append((A,B,C))

edges.sort(key=lambda x:(x[2]))

def find_parent(x):
    if parents[x]!=x:
        return find_parent(parents[x])
    return parents[x]

def union_parent(x,y):
    a=find_parent(x)
    b=find_parent(y)
    if a<b:
        parents[b]=a
    else:
        parents[a]=b


total=0
for i in range (len(edges)):
    a,b,c=edges[i]
    if find_parent(a)!=find_parent(b):
        union_parent(a,b)
        total+=c

print(total)
