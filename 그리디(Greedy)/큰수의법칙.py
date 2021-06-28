n, m, k = map(int, input().split())
data = list(map(int, input().split()))

result = 0
data.sort(reverse=True)
a = m // (k + 1) * k + (m % (k + 1))
result += data[0] * a
result += data[1] * (m - a)

print(result)
