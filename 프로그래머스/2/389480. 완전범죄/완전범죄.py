def solution(info, n, m):
    L=len(info)
    INF=float('inf')
    
    dp=[[INF] * m for _ in range (L+1)]
    dp[0][0]=0
    
    for i in range (L):
        a_cost,b_cost=info[i]
        for b in range(m):
            if dp[i][b]==INF:
                continue
            
            new_a=dp[i][b]+a_cost
            if new_a<n:
                dp[i+1][b]=min(dp[i+1][b],new_a)
            new_b=b+b_cost
            if new_b<m:
                dp[i+1][new_b]=min(dp[i+1][new_b],dp[i][b])
    
    answer=min(dp[L])
                
    return answer if answer!=INF else -1