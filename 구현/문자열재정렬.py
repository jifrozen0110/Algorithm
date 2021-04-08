n=input()
a=[]
b=[]

for i in range(len(n)):
    if n[i].isalpha():
        a.append(n[i])
    else:
        b.append(n[i])
a.sort()
b.sort()

for i in range(len(a)):
    print(a[i],end='')
for i in range(len(b)):
    print(b[i],end='')
