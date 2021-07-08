selfNum = set(range(1, 10001))
removeNum = set()
for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    removeNum.add(i)

selfNum = sorted(selfNum - removeNum)

for i in selfNum:
    print(i)
