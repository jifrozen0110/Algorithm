a=int(input())
b=list(input())


sum=0
index=0
for i in list(reversed(b)):
    num=int(i)*a
    print(num)
    sum+=(num*pow(10,index))
    index+=1

print(sum)



