import sys

input=sys.stdin.readline

N=int(input())
A,B=map(int,input().split())
C=int(input())
toppings=list(int(input()) for _ in range (N))

toppings.sort(reverse=True)


total=C
cost=A


for i in range (len(toppings)):
    if (total/cost)<toppings[i]/B:
        total+=toppings[i]
        cost+=B
    else:
        break

print(int(total/cost))
