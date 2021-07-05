n = input()
row = int(n[1])
column = int(ord(n[0])) - int(ord('a')) + 1
data = [(2, -1), (2, 1), (-2, 1), (-2, -1), (1, 2), (-1, 2), (1, -2), (-1, -2)]

nx, ny = 0, 0
result = 0
for i in data:
    nx = row + i[0]
    ny = column + i[1]
    if nx >= 1 and nx < 9 and ny >= 1 and ny < 9:
        result += 1

print(result)
