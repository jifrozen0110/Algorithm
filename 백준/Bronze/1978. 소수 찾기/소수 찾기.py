import sys
def isPrime(n):
    if n==1:
        return False
    for i in range (2,n//2+1):
        if n%i==0:
            return False
    return True
input=sys.stdin.readline

N=int(input())
arr=list(map(int,input().split()))

answer=0
for a in arr:
    if isPrime(a):
        answer+=1

print(answer)


