# https://www.acmicpc.net/problem/1052
import sys

input = sys.stdin.readline

N, K = map(int, input().split())

answer = 0
# 3 이진수 11 -> 2개 만들어지는 물병 개수
# 4-> 100 -> 1개 만들어지는 물변 개수
# 위 이진수 이용 -> 물병의 개수보다 크면 마트에서 물병 사옴
while bin(N).count('1') > K:
    # 역순으로 index가 1인 경우
    plus = 2 ** (bin(N)[::-1].index('1'))
    answer += plus
    N += plus
print(answer)
