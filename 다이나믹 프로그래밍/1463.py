x = int(input())

d = [0] * (x + 1)

for i in range(2, x + 1):
    # 1을 뺀 경우
    d[i] = d[i - 1] + 1
    # 2로 나누어지는 경우
    if i % 2 == 0:
        # 1로 뺀경우랑 2로 나누어지는 경우 둘이 비교해서 작은거
        d[i] = min(d[i], d[i // 2] + 1)
    # 3으로 나누어 지는 경우
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)

print(d[x])
