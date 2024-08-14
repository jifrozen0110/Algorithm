import sys
input=sys.stdin.readline

A,B,C=map(int,input().split())

def calc(base,n):
    if n==1:
        return base%C
    if n%2==0:
        return calc(base**2%C,n//2)%C
    else:
        return calc(base**2%C,n//2)*base%C

print(calc(A,B))

