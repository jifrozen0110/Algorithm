change = [500, 100, 50, 10]

money = int(input())
total = 0
for c in change:
    if money == 0:
        continue
    a = money // c
    total += a
    money -= c * a

print(total)
