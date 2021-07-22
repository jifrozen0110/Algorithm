# https://programmers.co.kr/learn/courses/30/lessons/42746

def solution(numbers):
    for i in range(len(numbers)):
        numbers[i] = str(numbers[i])
    answer = []
    numbers = sorted(numbers, key=lambda x: (x * 4)[:4], reverse=True)
    if numbers[0] != '0':
        answer = "".join(numbers)
    else:
        return '0'

    return answer


print(solution([0, 0, 0]))
