import math
def solution(n, k):
    # k진수로 변경
    # 소수찾기
    answer = 0
    targets=numToKinary(n,k).split("0")

    print(targets)
    for target in targets:
        if target=='':
            continue
        if(checkPrime(int(target))):
            answer+=1
    return answer

def checkPrime(n):
    if n==1:
        return False
    for i in range (2,int(math.sqrt(n))+1):
        if n%i==0:
            return False
    return True
    
def numToKinary(n,k):
    answer=""
    while n//k>0:
        answer+=str(n%k)
        n=n//k
    answer+=str(n%k)
    return answer[::-1]
    
    
    