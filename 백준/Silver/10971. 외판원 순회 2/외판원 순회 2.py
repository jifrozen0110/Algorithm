import sys
input=sys.stdin.readline

N=int(input())
min_value=10000001
arr=[list(map(int,input().split())) for _ in range (N)]

visited=[False]*N

def back(cnt,value,last,start):
    global min_value
    if value>min_value:
        return
    if cnt==N and arr[last][start]!=0:
        min_value=min(min_value,value+arr[last][start])
        return
    for i in range (N):
        if not visited[i] and arr[last][i]!=0:
          visited[i]=True
          back(cnt+1,value+arr[last][i],i,start)
          visited[i]=False

for i in range (N):
    if not visited[i]:
        visited[i]=True
        back(1,0,i,i)
        visited[i]=False
print(min_value)