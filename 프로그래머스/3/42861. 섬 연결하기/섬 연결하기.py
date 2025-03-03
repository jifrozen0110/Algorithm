def find(node,parents):
    if parents[node]==node:
        return node
    return find(parents[node],parents)

def solution(n, costs):
    answer = 0
    
    parents=[i for i in range (n)]
    
    edges=sorted([(cost[2],cost[0],cost[1]) for cost in costs])
    cnt=0
    for edge in edges:
        if find(edge[1],parents)!=find(edge[2],parents):
            parents[find(edge[2],parents)]=edge[1]
            answer+=edge[0]
            cnt+=1
        if cnt==n-1:
            break;
        
    return answer