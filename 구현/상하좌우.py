n=int(input())
a,b=1,1
data=list(input().split())

for i in range (len(data)):
    if data[i]=='L':
        if b>1:
            b-=1
    if data[i]=='R':
        if b <n:
            b+=1
    if data[i]=='U':
        if a>1:
            a-=1
    if data[i]=='D':
        if a<n:
            a+=1

print(a,b)