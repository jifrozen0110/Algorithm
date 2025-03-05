import sys

input=sys.stdin.readline

str=input().strip()
word=input().strip()
answer=0
index=0
while index<len(str):
    if str[index:index+len(word)]==word:
        answer+=1
        index+=len(word)
    else:
        index+=1

print(answer)