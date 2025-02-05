from collections import defaultdict

def solution(nums):
    answer = 0
    pocketmon=defaultdict(int)
    
    for num in nums:
        pocketmon[num]+=1
    
    return min(len(nums)//2,len(pocketmon))