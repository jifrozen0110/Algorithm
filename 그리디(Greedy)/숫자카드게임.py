n, m = map(int, input().split())
result = []
for i in range(n):
    result.append(min(list(map(int, input().split()))))

print(max(result))
