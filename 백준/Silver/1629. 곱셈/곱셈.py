import sys
sys.setrecursionlimit(10**8)
input=sys.stdin.readline

A,B,C=map(int,input().split())

# def multify(cnt):
#     if cnt==B:
#         return 1
#     return multify(cnt+1)*A%C

print(pow(A,B,C))
