import sys
input=sys.stdin.readline

_, target=map(int,input().split())
minCard=0
cards=list(map(int,input().split()))
cards.sort()
total=len(cards)
for i in range(0,total):
    for j in range(i+1,total):
        for k in range(j+1,total):
            sum=cards[i]+cards[j]+cards[k]
            if sum<=target and minCard<sum:
                minCard=sum

print(minCard)