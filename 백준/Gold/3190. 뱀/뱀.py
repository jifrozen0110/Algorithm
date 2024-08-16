import sys
from collections import deque
input=sys.stdin.readline

N=int(input())
K=int(input())

dx=[0,1,0,-1]
dy=[1,0,-1,0]


arr=[[0] * N for _ in range (N)]

for _ in range(K):
    a,b=map(int,input().split())
    arr[a-1][b-1]=1

L=int(input())

time=[]
for _ in range (L):
    x,c=input().split()
    time.append((int(x),c))

x,y=0,0
arr[x][y]=2
q=deque([(0,0)])
d=0
sec=0
index=0
while True:

    nx=x+dx[d]
    ny=y+dy[d]
    sec+=1
    if index<len(time) and time[index][0]==sec:
        x,c=time[index]
        index+=1
        if c=='D':
            d+=1
        else:
            d-=1
        if d==-1:
            d=3
        elif d==4:
            d=0


    if nx<0 or ny<0 or nx>=N or ny>=N:
        break;

    if arr[nx][ny]==2:
        break;


    if arr[nx][ny]!=1:
        prevX,prevY=q.popleft()
        arr[prevX][prevY]=0
    q.append((nx,ny))
    arr[nx][ny]=2
    x=nx
    y=ny


print(sec)