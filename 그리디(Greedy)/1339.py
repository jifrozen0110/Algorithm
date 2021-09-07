# https://www.acmicpc.net/problem/1339
n = int(input())
data = [input() for _ in range(n)]
result = 0
a_dict = {}
number = []
for i in range(len(data)):
    for j in range(len(data[i])):
        if data[i][j] in a_dict:
            a_dict[data[i][j]] += 10 ** (len(data[i]) - j - 1)
        else:
            a_dict[data[i][j]] = 10 ** (len(data[i]) - j - 1)

for n in a_dict.values():
    number.append(n)

number.sort(reverse=True)

a = 9
for i in range(len(number)):
    result += number[i] * a
    a -= 1
print(result)
