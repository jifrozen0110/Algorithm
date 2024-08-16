from collections import deque
import sys

input=sys.stdin.readline

N=int(input())
q=deque([])

results=[]
while N>0:
    N-=1
    command=input().rstrip()

    if command=="size":
        results.append(len(q))
    elif command=="empty":
        results.append(1 if len(q)==0 else 0)
    elif command=="pop":
        if len(q)==0:
            results.append(-1)
            continue
        results.append(q.popleft())
    elif command=="front":
        if len(q)==0:
            results.append(-1)
            continue
        results.append(q[0])
    elif command=="back":
        if len(q)==0:
            results.append(-1)
            continue
        results.append(q[-1])
    else:
        commands=command.split()
        q.append(int(commands[1]))

print(*results,sep='\n')
