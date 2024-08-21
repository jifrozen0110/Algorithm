import sys
input=sys.stdin.readline
index=1
while True:
    str=input().rstrip()
    if str[0]=='-':
        break;
    stack=[]
    total=0
    for i in range (len(str)):
        if str[i]=='{':
            stack.append("{")
        else:
            if not stack:
                stack.append("{")
                total+=1
            else:
                stack.pop()

    print(f"{index}. {len(stack)//2+total}")
    index+=1