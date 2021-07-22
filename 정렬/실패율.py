# https://programmers.co.kr/learn/courses/30/lessons/42889

def solution(n, stages):
    answer = []
    # 계수정렬 생각하고 품
    count = [0] * (n + 1)
    for i in range(len(stages)):
        count[stages[i] - 1] += 1
    for j in range(n):
        if count[j] == 0:
            answer.append([0, j + 1])
        else:
            answer.append([count[j] / sum(count[j:len(count)]), j + 1])
    result = [0] * n
    answer = sorted(answer, key=lambda answer: -answer[0])
    for k in range(n):
        result[k] = answer[k][1]
    return result


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
