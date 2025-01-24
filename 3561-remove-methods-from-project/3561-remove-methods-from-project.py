
class Solution:
    def remainingMethods(
        self, n: int, k: int, invocations: List[List[int]]
    ) -> List[int]:
        graph = defaultdict(list)
        degree = [0] * n
        for start, end in invocations:
            graph[start].append(end)
            degree[end] += 1
        answer = [i for i in range(n)]
        visited = set()
        queue = deque()
        queue.append(k)
        while queue:
            pos = queue.popleft()
            if pos in visited:
                continue
            visited.add(pos)
            for next in graph[pos]:
                degree[next] -= 1
                queue.append(next)
        print(visited)

        if all(degree[v] == 0 for v in visited):
            return list(set(answer)-visited)
        return answer
