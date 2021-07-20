n=int(input())
data=[]

for i in range (n):
    data.append(list(input().split()))

data=sorted(data,key=lambda data : data[1])

for i in range(n):
    print(data[i][0])
