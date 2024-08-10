import sys

input=sys.stdin.readline

N=int(input())

numbers=list(map(int,input().split()))
operation=list(map(int,input().split()))

minAns=10**9
maxAns=-10**9

def pickOperations(sum,index):
    global minAns,maxAns
    if index==N:
        minAns=min(minAns,sum)
        maxAns=max(maxAns,sum)
        return
    for i in range (4):
        if operation[i]>0:
            operation[i]-=1
            if i==0:
                pickOperations(sum+numbers[index],index+1)
            elif i==1:
                pickOperations(sum-numbers[index],index+1)
            elif i==2:
                pickOperations(sum*numbers[index],index+1)
            else:
                if sum<0:
                    sum=-sum
                    pickOperations(-(sum//numbers[index]),index+1)
                else:
                    pickOperations(sum//numbers[index],index+1)
            operation[i]+=1

pickOperations(numbers[0],1)

print(f'{maxAns}\n{minAns}')