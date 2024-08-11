import sys

input=sys.stdin.readline
A,B,C=map(int,input().split())

answer=1
b = bin(B)[2:][::-1]

ap=[A]

for _ in range (len(b)-1):
    ap.append(ap[-1]**2%C)

for i in range (len(b)):
    if b[i]=='1':
        answer=(answer*ap[i])%C

print(answer%C)