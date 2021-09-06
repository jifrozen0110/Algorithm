n, k, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort(reverse=True)
m1 = data[0]
m2 = data[1]
a = k // (m + 1)
total = m2 * a + m1 * (k - a)
print(total)
