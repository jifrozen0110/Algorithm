n,m,k=map(int,input().split())
data=list(map(int,input().split()))


data.sort()
first=data[n-1]
second=data[n-2]
a=0
for i in range(1,m+1):
    if i%(k+1)!=0:
        a=a+first
    else:
        a=a+second


print(a)

