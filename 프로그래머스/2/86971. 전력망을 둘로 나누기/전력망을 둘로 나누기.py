def solution(n, wires):
    answer = n

    graph = [[] for _ in range(n + 1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    def DFS(node, visited):
        count=1
        visited[node]=True
        for n in graph[node]:
            if not visited[n]:
                count+=DFS(n,visited)
        return count

    for a, b in wires:
        graph[a].remove(b)
        graph[b].remove(a)

        visited = [False] * (n + 1)
        count = DFS(a, visited)

        diff = abs((n - count) - count)
        answer = min(answer, diff)

        graph[a].append(b)
        graph[b].append(a)

    return answer
