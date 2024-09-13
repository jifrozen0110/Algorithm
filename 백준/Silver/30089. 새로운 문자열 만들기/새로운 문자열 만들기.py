import sys

input=sys.stdin.readline

T=int(input())

for _ in range (T):
    S=input().strip()

    for i in range (len(S)):
        if S[i:]==S[i:][::-1]:
            if i==0:
                break
            S+=S[i-1::-1]
            break

    print(S)

