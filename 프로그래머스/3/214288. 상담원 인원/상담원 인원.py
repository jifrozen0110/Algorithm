import heapq
from collections import defaultdict

answer = float('inf')  # 무한대 값

def solution(k, n, reqs):
    global answer
    cnt = [1] * (k + 1)  # 각 상담유형에 최소 1명씩 배치
    n -= k  # 이미 1명씩은 줬으니까 남은 인원
    
    waiting_list = defaultdict(list)
    for a, b, c in reqs:
        waiting_list[c].append((a, b))  # 요청 시간, 상담 시간
    
    comb(n, 0, cnt, waiting_list, 1)
    return answer

def comb(remaining, index, arr, waiting_list, pos):
    global answer
    if remaining == 0:
        # 조합 완성
        cur_sum = 0
        for idx, c in enumerate(arr[1:], 1):
            cur_sum += select(c, waiting_list[idx])
        answer = min(answer, cur_sum)
        return
    
    # **Pruning: 현재 상담유형(pos)부터 인원 추가**
    for i in range(pos, len(arr)):
        arr[i] += 1
        comb(remaining - 1, index + 1, arr, waiting_list, i)  # 같은 유형에 또 배정 가능
        arr[i] -= 1

def select(cnt, waiting):
    my_heap = [0] * cnt  # cnt명 상담사의 현재 끝나는 시간
    total_waiting = 0
    
    for req_time, duration in waiting:
        available_time = heapq.heappop(my_heap)
        if available_time <= req_time:
            heapq.heappush(my_heap, req_time + duration)
        else:
            total_waiting += available_time - req_time
            heapq.heappush(my_heap, available_time + duration)
    
    return total_waiting
