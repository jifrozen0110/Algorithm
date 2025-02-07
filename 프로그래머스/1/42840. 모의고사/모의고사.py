def solution(answers):
    answer = []
    
    one=[1,2,3,4,5]
    two=[2,1,2,3,2,4,2,5]
    three=[3,3,1,1,2,2,4,4,5,5]
    score=[0,0,0]
    for i in range (len(answers)):
        if one[i%len(one)]==answers[i]:
            score[0]+=1
        if two[i%len(two)]==answers[i]:
            score[1]+=1
        if three[i%len(three)]==answers[i]:
            score[2]+=1
            
    max_value=max(score)
    
    for i in range (len(score)):
        if max_value==score[i]:
            answer.append(i+1)
            
    return answer