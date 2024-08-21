import sys
input = sys.stdin.readline

N = int(input())

buildings = [int(input()) for _ in range(N)]

stack = []
total = 0

for i in range(N):
    while stack and buildings[stack[-1]] <= buildings[i]:
        stack.pop()
    total += len(stack)
    stack.append(i)

print(total)
