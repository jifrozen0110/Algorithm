a=list(input().split('-'))
num=[]

for i in a:
    sum=0
    n=i.split('+')
    for j in n:
        sum+=int(j)
    num.append(sum)

result=num[0]
for j in range (1,len(num)):
    result=result-num[j]

print(result)
