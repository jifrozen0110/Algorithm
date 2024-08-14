# 4
# 123 1 1
# 356 1 0
# 327 2 0
# 489 0 1

import sys
input=sys.stdin.readline

N=int(input())
games=[]
for _ in range (N):
    num_str,strike,ball=input().split()
    num_list=list(map(int,num_str))
    strike=int(strike)
    ball=int(ball)
    games.append((num_list,strike,ball))

visited=[0]*10
answer=0
def start(result):
    global answer
    for game in games:
        compareNum=game[0]
        strike=game[1]
        ball=game[2]
        s,b=checkNumber(result,compareNum)
        if s!=strike or ball!=b:
            return
    answer+=1


def checkNumber(original,target):
    strike=0
    ball=0
    for i in range (len(original)):
        if original[i]==target[i]:
            strike+=1
            continue
        if original[i] in target:
            ball+=1
    return strike,ball


def makeNumber(result,cnt):
    if cnt==3:
        start(result)
    for i in range(1,10):
        if not visited[i]:
            visited[i]=True
            makeNumber(result+[i],cnt+1)
            visited[i]=False


makeNumber([],0)
print(answer)
