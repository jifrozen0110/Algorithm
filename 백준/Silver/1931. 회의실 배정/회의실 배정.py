import sys

input=sys.stdin.readline

N=int(input())

meetings=[]

for _ in range (N):
    start,end=map(int,input().split())

    meetings.append((start,end))

meetings.sort(key=lambda x: (x[1],x[0]))
start=0
total=0
for s,e in meetings:
    if start<=s:
        start=e;
        total+=1
    else:
        continue

print(total)
