import math

def isPrime(num):

    if num==1:
        return False
    if num==2 or num==3:
        return True
    if num%2==0:
        return False

    for i in range(3,int(math.sqrt(num)+1),2):
        if num%i==0:
            return False
    return True

def main():
    N=int(input())

    answer=0
    nums=list(map(int,input().split()))

    for num in nums:
        if(isPrime(num)):
            answer+=1
    print(answer)


if __name__=="__main__":
    main()


