import heapq
n = int(input())
card = []
for _ in range(n):
    data = int(input())
    heapq.heappush(card, data)

result = 0
while len(card) != 1:
    first = heapq.heappop(card)
    second = heapq.heappop(card)
    sum_value = first + second
    result += sum_value
    heapq.heappush(card, sum_value)
print(result)