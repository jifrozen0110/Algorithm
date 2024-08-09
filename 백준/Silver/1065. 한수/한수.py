num=int(input())
answer=0
for i in range (100,num+1):
    i=str(i)
    gap=int(i[0])-int(i[1])
    isHansu=True
    for j in range(1,len(i)-1):
        if gap!=int(i[j])-int(i[j+1]):
            isHansu=False
            break;
    if isHansu:
        answer+=1

if num<100:
    print(num)
else:
    print(99+answer)


