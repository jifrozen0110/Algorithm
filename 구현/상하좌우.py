n=int(input())
data=list(input().split())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
dr=['L','R','U','D']

x,y=1,1

for i in data:
    for j in range (4):
        if i==dr[j]:
            if 5>=x+dx[j]>0 and 5>=y+dy[j]>0:
                x=x+dx[j]
                y=y+dy[j]

print(y,x)