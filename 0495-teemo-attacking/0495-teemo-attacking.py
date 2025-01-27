class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        timeSeries.sort()
        answer=len(timeSeries)*duration

        for i in range (len(timeSeries)-1):
            if timeSeries[i]+duration>timeSeries[i+1]:
                answer-=(timeSeries[i]+duration-timeSeries[i+1])
        return answer

        