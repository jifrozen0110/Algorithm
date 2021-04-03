data=input()
n=[]
for i in data:
    n.append(int(i))

n.sort()
result=n[0]
for i in range (1,len(n)):
    num=n[i]
    if num<=1 or result<=1:
        result+=num
    else:
        result=result*num

print(result)