data = list(map(int, input()))
a = data[0]

for i in range(1, len(data)):
    if a <= 1 or data[i] <= 1:
        a = a + data[i]
    else:
        a = a * data[i]

print(a)
