def solution(info, n, m):
    num_items = len(info)
    
    max_a = n
    max_b = m
    
    dp=[[[1e9] * (max_b+1) for _ in range (max_a+1)] for _ in range (num_items+1)]
    dp[0][0][0]=0
    
    for i in range (1,num_items+1):
        a_trace,b_trace=info[i-1]
        for a in range (max_a+1):
            for b in range (max_b+1):
                if dp[i-1][a][b]!=1e9:
                    if a+a_trace<=max_a:
                        dp[i][a+a_trace][b]=min(dp[i][a+a_trace][b],dp[i-1][a][b]+a_trace)
                    if b+b_trace<=max_b:
                        dp[i][a][b+b_trace]=min(dp[i][a][b+b_trace],dp[i-1][a][b])
    
    min_a_trace=1e9
    for a in range(max_a):
        for b in range (max_b):
            min_a_trace=min(min_a_trace,dp[num_items][a][b])
            
    return min_a_trace if min_a_trace != 1e9 else -1