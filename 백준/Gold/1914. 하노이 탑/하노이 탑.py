import sys
input=sys.stdin.readline
def move(no,x,y,num):
    if no>1:
        move(no-1,x,6-x-y,num)

    print(f'{x} {y}')

    if no>1:
        move(no-1,6-x-y,y,num)

K=int(input())
print(2**K-1)

if K<=20:
    move(K,1,3,K)

