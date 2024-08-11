import sys

input=sys.stdin.readline



def pickNumber(cnt,answer):
    if cnt==M:
        print(answer.lstrip())
        return
    for i in range(1,N+1):
        if not visited[i]:
            visited[i]=True;
            pickNumber(cnt+1,f'{answer} {str(i)}')
            visited[i]=False


N,M=map(int,input().split())
visited=[False]*(N+1)
arr=[]
pickNumber(0,"")
