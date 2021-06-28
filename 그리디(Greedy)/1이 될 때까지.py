n, k = map(int, input().split())

result = 0

while (n >= k):
    if (n // k > 0):
        result += n % k
        n = n // k
        result += 1

while n > 1:
    if n == 1:
        break
    n = n - 1
    result += 1

print(result)
