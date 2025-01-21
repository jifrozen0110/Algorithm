import sys
input=sys.stdin.readline

n=int(input())



while n!=-1:
    arr=[1]
    sum=1
    for i in range (2,int(n**0.5)+1):
        if n%i==0:
            sum+=i
            sum+=(n/i)
            arr.append(i)
            arr.append(n//i)
    arr.sort()
    if sum==n:
        print(f"{n} = ",end='')
        print(*arr,sep=" + ")
    else:
        print(f"{n} is NOT perfect.")
    n=int(input())



