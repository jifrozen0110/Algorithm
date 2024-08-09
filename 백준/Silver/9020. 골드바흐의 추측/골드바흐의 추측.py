import sys
import math


def eratosthenes(n,is_prime):
    p=2
    while (p*p<=n):
        if is_prime[p]==True:
            for i in range(p*p,n+1,p):
                is_prime[i]=False
        p+=1


def main():
    T=int(input())

    a=[int(sys.stdin.readline()) for _ in range(T)]
    is_prime=[True]*(max(a)+1)
    eratosthenes(max(a),is_prime)

    x,y=0,0
    for num in a:
        for i in range (2,num//2+1):
            if is_prime[i] and is_prime[num-i]:
                x=i
                y=num-i

        print(f'{x} {y}')

if __name__=="__main__":
    main()
