from collections import Counter

n = int(input())

data = [int(input()) for _ in range(n)]

data.sort()
print(round(sum(data) / len(data)))
print(data[len(data) // 2])
count = Counter(data)
modes = count.most_common()
if len(data) > 1:
    if modes[0][1] == modes[1][1]:
        print(modes[1][0])
    else:
        print(modes[0][0])
else:
    print(modes[0][0])

print(data[-1] - data[0])
