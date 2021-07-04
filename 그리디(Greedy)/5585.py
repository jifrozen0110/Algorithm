# https://www.acmicpc.net/problem/5585
# 거스름돈
change = [500, 100, 50, 10, 5, 1]

n = int(input())
money = 1000 - n
result = 0
for i in change:
    if money >= i:
        result = result + money // i
        money = money % i

print(result)
