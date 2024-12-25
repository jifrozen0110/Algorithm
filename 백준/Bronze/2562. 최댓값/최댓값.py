import sys

nums=[int(sys.stdin.readline()) for _ in range(9)]

maxinum=max(nums)
print(maxinum)
print(nums.index(maxinum)+1)