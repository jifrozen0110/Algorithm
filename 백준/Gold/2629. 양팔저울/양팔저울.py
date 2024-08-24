import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

n = int(input())
chu = list(map(int, input().split()))

b = int(input())
balls = list(map(int, input().split()))

dp = [[False] * 15001 for _ in range(n + 1)]

def calc(idx, left, right):
    diff = abs(left - right)
    
    if diff > 15000 or dp[idx][diff]:
        return
    
    dp[idx][diff] = True
    
    if idx == n:
        return
    
    calc(idx + 1, left + chu[idx], right)
    calc(idx + 1, left, right + chu[idx])
    calc(idx + 1, left, right)

calc(0, 0, 0)

result = []
for ball in balls:
    if ball > 15000:
        result.append("N")
    else:
        if dp[n][ball]:
            result.append("Y")
        else:
            result.append("N")

print(" ".join(result))
