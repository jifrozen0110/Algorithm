import sys

C=int(input())

for _ in range(C):
    students=list(map(int,sys.stdin.readline().split()))

    aveg=(sum(students)-students[0])/students[0]

    good=0
    for i in range(1,len(students)):
        if aveg<students[i]:
            good+=1

    print('%.3f%%'%(good/students[0]*100))