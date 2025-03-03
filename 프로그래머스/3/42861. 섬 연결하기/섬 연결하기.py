import heapq

def solution(n, costs):
    answer = 0
    visited=[False]*n
    
    graph={i : [] for i in range (n)}
    start=-1
    minValue=1e9
    
    for cost in costs:
        graph[cost[0]].append((cost[1],cost[2]))
        graph[cost[1]].append((cost[0],cost[2]))

    min_heap=[(0,0)]
    
    while min_heap:
        cost,u=heapq.heappop(min_heap)
        if visited[u]:
            continue
        visited[u]=True
        answer+=cost
        for v,cost in graph[u]:
            if not visited[v]:
                heapq.heappush(min_heap,(cost,v))
    
    return answer