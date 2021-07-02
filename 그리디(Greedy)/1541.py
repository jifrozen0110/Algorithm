a=list(input().split('-'))
num=[]

for i in a:
    sum=0
    print(i)
    n=i.split('+')
    print(n)
    for j in n:
        sum+=int(j)
    num.append(sum)
print(num)
result=num[0]
for j in range (1,len(num)):
    result=result-num[j]

print(result)
