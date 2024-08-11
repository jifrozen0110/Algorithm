import sys
input=sys.stdin.readline

N=int(input())

arr=[]

for _ in range (N):
    arr.append(list(map(int,input().split())))

whitePaper=0
bluePaper=0

def cutPaper(x1,y1,x2,y2,n):
    if(checkPaper(x1,y1,x2,y2,n)):
        return

    cutPaper(x1,y1,x1+((n-1)//2),y1+((n-1)//2),n//2)
    cutPaper(x1+(n//2),y1,x2,y1+((n-1)//2),n//2)
    cutPaper(x1,y1+(n//2),x1+((n-1)//2),y2,n//2)
    cutPaper(x1+((n-1)//2)+1,y1+((n-1)//2)+1,x2,y2,n//2)


def checkPaper(x1,y1,x2,y2,n):
    global whitePaper, bluePaper
    sumVal=0;
    for i in range (x1,x2+1):
        for j in range (y1,y2+1):
            sumVal+=arr[i][j]
    papersSize=n*n
    if sumVal==0:
        whitePaper+=1
        return True
    if sumVal==papersSize:
        bluePaper+=1
        return True
    return False

cutPaper(0,0,N-1,N-1,N)

print(f"{whitePaper}\n{bluePaper}")