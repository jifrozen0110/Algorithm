import sys
import heapq
input = sys.stdin.readline
N = int(input())
graph=[[] for _ in range (N)]
indegree=[0]*(N)
for i in range (N):
    str=input().rstrip()
    for j in range (N):
        if str[j]=='1':
            graph[j].append(i)
            indegree[i]+=1

heap=[]

for i in range(N):
    if indegree[i] == 0:
        heapq.heappush(heap,-i)

result = [0] * N
numbering = N
while heap:
    now = -heapq.heappop(heap)

    result[now] = numbering
    numbering -= 1

    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            heapq.heappush(heap,-i)

if numbering != 0:
    print(-1)
else:
    print(*result)