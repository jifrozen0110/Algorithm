count=0
a=[]

for n in range (8):
    a.append(list(map(str,list(input()))))

for i in range(8):
    for j in range(8):
        if (i+j)%2==0:
            if a[i][j]=='F':
                count+=1

print(count)



