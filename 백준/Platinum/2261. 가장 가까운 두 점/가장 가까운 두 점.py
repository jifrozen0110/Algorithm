import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

n=int(input())

cords=[tuple(map(int,input().split())) for _ in range (n)]
originalSize=len(cords)
cords=list(set(cords))



x_sortCords=sorted(cords)
y_sortCords=sorted(cords,key=lambda x:x[1])

def getDistance(x,y):
    return (x[0]-y[0])**2+(x[1]-y[1])**2


answer=100000**2+100000**2

def divide(left,right):
    global answer
    if right-left<=3:
        for i in range(left,right-1):
            for j in range (i+1,right):
                answer=min(answer,(x_sortCords[i][0]-x_sortCords[j][0])**2+(x_sortCords[i][1]-x_sortCords[j][1])**2)
        return

    mid=(left+right)//2

    divide(left,mid)
    divide(mid,right)

    divide_x=x_sortCords[mid][0]
    candidateKey=[]

    for i in range (left,right):
        if (x_sortCords[i][0]-divide_x)**2<answer:
            candidateKey.append(x_sortCords[i])

    candidateKey.sort(key=lambda x:x[1])

    for i in range (len(candidateKey)):
        for j in range (i+1,len(candidateKey)):
            simpleDist=(candidateKey[i][1]-candidateKey[j][1])**2
            if simpleDist>=answer:
                break;
            answer=min(answer,(candidateKey[i][0]-candidateKey[j][0])**2+(candidateKey[i][1]-candidateKey[j][1])**2)


if len(cords)!=originalSize:
    answer=0
else:
    divide(0,len(cords))



print(answer)


