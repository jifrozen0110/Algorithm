import sys
input=sys.stdin.readline

n=int(input())

arr=[input().rstrip() for _ in range (n)]
arr=set(arr)
arr=sorted(arr,key=lambda x: (len(x),x))

print(*arr,sep='\n')