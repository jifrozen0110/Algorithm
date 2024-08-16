str = input()

stack = []
temp=1
answer=0

for i in range (len(str)):
    s=str[i]
    if s=="(":
        stack.append(s)
        temp*=2
    elif s=="[":
        stack.append(s)
        temp*=3
    elif s==")":
        if not stack or stack[-1]!="(":
            answer=0
            break;
        if str[i-1]=="(":
            answer+=temp
        stack.pop()
        temp=temp//2
    elif s==']':
        if not stack or stack[-1]!="[":
            answer=0
            break;
        if str[i-1]=="[":
            answer+=temp
        stack.pop()
        temp=temp//3

if stack:
    answer=0
    
print(answer)

