import sys

input=sys.stdin.readline

N,K=map(int,input().split())

mon=[int(input()) for _ in range (N)]
mon.sort(reverse=True)
total=0

for i in range (N):
    if K//mon[i]>0:
        total+=K//mon[i]
        K=K%mon[i]

print(total)