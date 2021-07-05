# https://www.acmicpc.net/problem/1789
n = int(input())

i = 1
result=0
while True:
    n -= i
    if n>=0:
        i = i + 1
        result+=1
    else:
        break

print(result)
