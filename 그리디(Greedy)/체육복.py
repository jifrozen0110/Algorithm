def solution(n, lost, reserve):
    answer = 0
    data=[]
    count=0
    for i in range (31):
        data.append(1)
    for i in reserve:
        data[i-1]+=1
    for i in lost:
        data[i-1]-=1


    for i in range (n):
        if data[i]==2:
            if data[i-1]==0:
                data[i-1]+=1
                data[i]-=1
            elif data[i+1]==0:
                data[i+1]+=1
                data[i]-=1


    for i in range (n):
        if data[i]==0:
            count+=1

    return n-count

print(solution(5,[1,2,5],[2,4]))
