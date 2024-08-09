import sys
from itertools import permutations
input=sys.stdin.readline

n=int(input())

k=int(input())

cards=[input().rstrip() for _ in range(n)]

answers=set()

visited=[False]*len(cards)

def comb(index,choice):
    if(index==k):
        answers.add(choice)
        return
    for i in range(0,n):
        if not visited[i]:
            visited[i]=True
            comb(index+1,choice+cards[i])
            visited[i]=False



comb(0,"")

print(len(answers))