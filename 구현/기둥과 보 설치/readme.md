## 기둥과 보 설치

### 솔루션
1. 기둥과 보를 설피 또는 제거한다
2. 설치 또는 제거를 하기 위해 조건을 파악해야한다
기둥이 설치가 가능한 조건
1). 바닥 
2). 설치 왼쪽에 보가 있는 경우
3). 설치 지점에 보가 있는 경우
4). 설치 밑에 기둥이 있는 경우
보가 설치 가능한 조건
1). 설치 아래 기둥
2). 설치 오른쪽 아래 기둥
3). 양옆에 보가 있는경우
4. 우선 설치 삭제한 후 조건을 확인하고 추가한다.

https://programmers.co.kr/learn/courses/30/lessons/60061

```python
def possible(answer):
     for x,y,stuff in answer:
         if stuff==0:
             if y==0 or [x-1,y,1] in answer or [x,y,1] in answer or [x,y-1,0] in answer:
                 continue
             else:
                 return False
         elif stuff==1:
             if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                 continue
             else:
                 return False
     return True

def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x,y,stuff,operate=frame
        if operate==0:
            answer.remove([x,y,stuff])
            if not possible(answer):
                answer.append([x,y,stuff])
        else:
            answer.append([x,y,stuff])
            if not possible(answer):
                answer.remove([x,y,stuff])
    return sorted(answer)


print(solution
      (5,
      [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
      )
      )
      
 
