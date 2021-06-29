from math import ceil

data = list(map(int, input()))
m = data[0]
result = 0
for i in data:
    if i != m:
        m = i
        result += 1

print(ceil(result / 2))
