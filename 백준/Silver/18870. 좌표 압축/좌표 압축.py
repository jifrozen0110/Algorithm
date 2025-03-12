import sys
input=sys.stdin.readline

N=int(input())
arr=list(map(int,input().strip().split()))

my_dict={}
new_arr=sorted(set(arr))
answer=[]

for i in range (len(new_arr)):
        my_dict[new_arr[i]]=i


for i in range (len(arr)):
    answer.append(my_dict[arr[i]])


print(*answer,end='')