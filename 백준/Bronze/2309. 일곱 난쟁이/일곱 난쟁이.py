import sys

input=sys.stdin.readline

nanzangees=[int(input()) for _ in range(9)]

sumHeight=sum(nanzangees)
tmp=sumHeight

nanzangees.sort()
isCheck=False

for i in range(9):
    for j in range(i+1,9):
        if tmp-(nanzangees[i]+nanzangees[j])==100:
            expect=i,j
            isCheck=True
            break
    if isCheck:
        break



print(*(nanzangees[0:i]+nanzangees[i+1:j]+nanzangees[j+1:len(nanzangees)]),sep='\n')