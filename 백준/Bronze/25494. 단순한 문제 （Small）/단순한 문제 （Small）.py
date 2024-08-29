import sys
input=sys.stdin.readline

T=int(input())
results=[]
for _ in range (T):
    a,b,c=map(int,input().split())
    cnt=0
    for x in range (1,a+1):
        for y in range (1,b+1):
            for z in range (1,c+1):
                if (x%y)==(y%z)==(z%x):
                    cnt+=1

    results.append(cnt)

print(*results,sep='\n')