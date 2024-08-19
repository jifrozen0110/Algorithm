import sys

input=sys.stdin.readline

N=int(input())
# 2
# 1 3
# 5 1
stack=[]
dots=[]
for i in range(N):
    x,r=map(int,input().split())
    a=x-r
    b=x+r
    dots.append((a,'L'))
    dots.append((b,'R'))

dots.sort(key = lambda x:(-x[0],x[1]),reverse=True)
cnt=1
for dot in dots:
    if dot[1]=='L':
        stack.append(dot);
    else:
        prev_tw=0
        while stack:
            prev=stack.pop()
            if prev[1]=='L':
                width=dot[0]-prev[0]
                if width==prev_tw:
                    cnt+=2
                else:
                    cnt+=1
                stack.append((width,'M'))
                break;
            elif prev[1]=='M':
                prev_tw+=prev[0]

print(cnt)
