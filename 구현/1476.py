# https://www.acmicpc.net/problem/1476

E, S, M = map(int, input().split())
result = 0
iE, iS, iM = 0, 0, 0
while True:
    if E == iE and S == iS and M == iM:
        break
    else:
        iE += 1
        iS += 1
        iM += 1
        result += 1
    if iE > 15:
        iE = 1
    if iS > 28:
        iS = 1
    if iM >19:
        iM = 1

print(result)