## 톱니바퀴

### 솔루션
첫번째 시도 -> 실패

    1, 오른쪽 왼쪽 나눠서 생각
    
    -> 한꺼번에 회전하는 문제 && 자기자신은 무조건 한번 회전
    

두번째 시도 -> 해결
    
    1. 회전해야할 톱니바퀴를 한꺼번에 체크
       
        -check_turn 재귀 호출 이용 (재귀 호출 너무 헷갈려....)
        
       범위체크와 turn[start+1]==0 재귀 호출이니깐 조건 추가
    2. 체크한 톱니바퀴 회전
        회전은 주사위 문제때 아이디어를 이용

[주사위문제](../14499/readme.md)


### https://www.acmicpc.net/problem/14891
#### Gold V

```python
def check_turn(start):
    if start+1<4:
        if turn[start+1]==0 and data[start][2] != data[start + 1][6]:
            turn[start+1]=turn[start]*-1
            check_turn(start+1)
    if start-1>=0:
        if turn[start-1]==0 and data[start][6] != data[start - 1][2]:
            turn[start-1]=turn[start]*-1
            check_turn(start-1)


data = []
for i in range(4):
    data.append(list(input()))


n = int(input())
for i in range(n):
    start, clock = map(int, input().split())
    turn=[0 for _ in range (4)]
    start = start - 1
    turn[start]=clock
    check_turn(start)
    for t in range (len(turn)):
        if turn[t]==0:
            continue
        if turn[t] == -1:
            data[t][7], data[t][0], data[t][1], data[t][2], data[t][3], data[t][4], data[t][5], \
            data[t][6] = data[t][0], data[t][1], data[t][2], data[t][3], \
                             data[t][4], data[t][5], data[t][6], data[t][7]
        elif turn[t]==1:
            data[t][0], data[t][1], data[t][2], data[t][3], data[t][4], data[t][5], data[t][6], \
            data[t][7] = data[t][7], data[t][0], data[t][1], data[t][2], \
                             data[t][3], data[t][4], data[t][5], data[t][6]

result=0
for d in range (len(data)):
    if data[d][0]=='1':
        result+=pow(2,d)
    else:
        result+=0

print(result)

 
