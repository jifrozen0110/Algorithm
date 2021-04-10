test=int(input())
result=0
for i in range (test):
    h,w,n=map(int,input().split())
    if n%h==0:
        result=h*100+n//h
    else:
        result=n%h*100+n//h+1
    print(result)
