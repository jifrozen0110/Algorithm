import sys

input=sys.stdin.readline

str=input().strip()
word=input().strip()
answer=0
index=0
while index+len(word)-1<len(str):
    isWrong=False
    for j in range (len(word)):
        if str[index+j]!=word[j]:
            isWrong=True
            break
    if not isWrong:
        index=index+len(word)
        answer+=1
    else:
        index+=1


print(answer)