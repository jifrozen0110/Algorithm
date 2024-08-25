import sys

input=sys.stdin.readline

str=input().rstrip().split('-')
num=0
result=[]
for s in range (0,len(str)):
    p=str[s].split('+')
    temp=0
    for i in p:
        temp+=int(i)
    if s==0:
        num+=temp
    else:
        num-=temp

print(num)
