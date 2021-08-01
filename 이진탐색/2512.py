n=int(input())
data=list(map(int,input().split()))
m=int(input())

start,end=0,max(data)

while start<=end:
    num=0
    mid=(start+end)//2
    for i in data:
        if i<mid:
            num+=i
        else:
            num+=mid
    if num>m:
        end=mid-1
    else:
        start=mid+1

print(end)