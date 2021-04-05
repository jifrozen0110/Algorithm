n,k=map(int,input().split())
data=[]
count=0
for i in range (n):
    data.append(int(input()))
for i in range(n-1,-1,-1):
    if k==0:
        break
    if data[i]>k:
        continue
    count+=k//data[i]
    k=k%data[i]
print(count)

