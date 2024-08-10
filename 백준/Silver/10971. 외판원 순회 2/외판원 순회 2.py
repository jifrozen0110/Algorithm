import sys

input=sys.stdin.readline

T=int(input())

tracks=[list(map(int,input().split())) for _ in range(T)]

answer=10**9

def pickTrack(sum,cnt,current,start):
    global answer
    if sum>answer:
        return
    if cnt==T and tracks[current][start]!=0:
        if(answer>sum+tracks[current][start]):
            answer=sum+tracks[current][start]
        return
    for i in range(T):
        if not visited[i] and tracks[current][i]!=0:
            visited[i]=True
            pickTrack(sum+tracks[current][i],cnt+1,i,start)
            visited[i]=False

visited=[False]*T
for i in range(T):
    visited[i]=True
    pickTrack(0,1,i,i)
    visited[i]=False

print(answer)
