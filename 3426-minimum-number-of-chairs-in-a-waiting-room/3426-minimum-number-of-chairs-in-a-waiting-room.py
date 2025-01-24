class Solution:
    def minimumChairs(self, s: str) -> int:
        answer=0
        max_answer=0
        for person in s:
            if person=='E':
                answer+=1
            else:
                answer-=1
            max_answer=max(max_answer,answer)
        return max_answer