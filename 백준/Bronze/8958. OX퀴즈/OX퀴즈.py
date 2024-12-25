import sys

T=int(input())
a=[list(sys.stdin.readline().strip()) for _ in range (T)]

for a_list in a:
    kill=1
    score=0;
    for b in a_list:
        if b=='O':
            score+=kill
            kill+=1
        else:
            kill=1;
    print(score)