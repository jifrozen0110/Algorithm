n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
result = []
for i in range(n):
    result.append(min(data[i]))

print(max(result))
