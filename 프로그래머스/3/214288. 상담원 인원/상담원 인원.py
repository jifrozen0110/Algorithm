import heapq
from collections import defaultdict

answer = float('inf')

def solution(k, n, reqs):
    global answer
    cnt = [1] * (k + 1)
    n -= k
    waiting_list = defaultdict(list)
    
    for a, b, c in reqs:
        waiting_list[c].append((a, b)) 
    
    comb(n, 0, cnt, waiting_list,1)
    return answer

def comb(n, index, arr, waiting_list,pos):
    global answer
    if index == n:
        list_cnt = arr[:]
        cur_sum = 0
        for idx, c in enumerate(list_cnt[1:], 1):
            cur_sum += select(c, waiting_list[idx])
        answer = min(answer, cur_sum)
        return
    
    for i in range(pos, len(arr)):
        arr[i] += 1
        comb(n, index + 1, arr, waiting_list,i)
        arr[i] -= 1

def select(cnt, waiting):
    my_heap = [0] * cnt

    total_waiting = 0
    
    for req_time, duration in waiting:
        available_time = heapq.heappop(my_heap)
        if total_waiting>answer:
            return 1e9
        if available_time <= req_time:
            heapq.heappush(my_heap, req_time + duration)
        else:
            total_waiting += available_time - req_time
            heapq.heappush(my_heap, available_time + duration)
    
    return total_waiting
