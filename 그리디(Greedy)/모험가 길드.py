n=input().split()
data=list(map(int,input().split()))
data.sort()

result=0
count=0

for i in data:
    print(i)
    count+=1
    if count>=i:
        result+=1
        count=0

print(result)

