import sys

input=sys.stdin.readline
numbers=[int(input()) for _ in range (9)]

maxNum=(max(numbers))

index=numbers.index(maxNum)+1

print(maxNum)
print(index)