n=int(input())
data=[]
value=[]
for i in range (n):
    data.append(int(input()))

data.sort(reverse=True)

for i in range (n):
    value.append(data[i]*(i+1))
print(max(value))