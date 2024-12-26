import sys

input=sys.stdin.readline

str=input().split()

A=int(str[0][::-1])
B=int(str[1][::-1])

if A>B:
    print(A)
else:
    print(B)



