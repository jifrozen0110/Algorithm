# https://programmers.co.kr/learn/courses/30/lessons/60061


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