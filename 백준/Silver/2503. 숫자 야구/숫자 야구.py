import sys
input = sys.stdin.readline

N = int(input())
games = []
for _ in range(N):
    num_str, strike, ball = input().split()
    num_list = list(map(int, num_str))
    strike = int(strike)
    ball = int(ball)
    games.append((num_list, strike, ball))

answer = 0

def checkNumber(original, target):
    strike, ball = 0, 0
    for i in range(3):
        if original[i] == target[i]:
            strike += 1
        elif original[i] in target:
            ball += 1
    return strike, ball

def isValid(number):
    for compareNum, strike, ball in games:
        s, b = checkNumber(number, compareNum)
        if s != strike or b != ball:
            return False
    return True

def makeNumber():
    global answer
    for i in range(1, 10):
        for j in range(1, 10):
            if i == j:
                continue
            for k in range(1, 10):
                if i == k or j == k:
                    continue
                candidate = [i, j, k]
                if isValid(candidate):
                    answer += 1

makeNumber()
print(answer)
