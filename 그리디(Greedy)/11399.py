n=int(input())
data=list(map(int,input().split()))

data.sort()
result=0

for i in range (n):
    result+=data[i]*(n-i)

print(result)