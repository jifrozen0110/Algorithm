def solution(m, n, startX, startY, balls):
    answer = []
    for ball in balls:
        min_value=4000001
        if not(ball[0]==startX and ball[1]>startY):
            dist=(ball[0]-startX)**2+((n-ball[1])+(n-startY))**2
            min_value=min(min_value,dist)
        if not(ball[0]==startX and ball[1]<startY):
            dist=(ball[0]-startX)**2+((ball[1])+(startY))**2
            min_value=min(min_value,dist)
        if not(ball[1]==startY and ball[0]<startX):
            dist=(ball[1]-startY)**2+((ball[0])+(startX))**2
            min_value=min(min_value,dist)
        if not(ball[1]==startY and ball[0]>startX):
            dist=(ball[1]-startY)**2+((m-ball[0])+(m-startX))**2
            min_value=min(min_value,dist)
        answer.append(min_value)
    return answer