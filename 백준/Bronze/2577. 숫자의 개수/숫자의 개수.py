import sys

multiply=1
for _ in range(3):
    multiply*=int(sys.stdin.readline())


numbers=[0]*10
list_mul=list(str(multiply))
for num in list_mul:
    numbers[int(num)]+=1

for number in numbers:
    print(number)