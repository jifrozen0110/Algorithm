max=0
n=0
for i in range (9):
    data=int(input())
    if data>max:
        max=data
        n=i

print(max,n+1)