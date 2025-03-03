def solution(number, k):
    answer = ''
    stack=[]
    
    for i in range (len(number)):
        while k>0 and stack and stack[-1]<number[i]:
            stack.pop()
            k-=1
        stack.append(number[i])
    
    if k>0:
        stack=stack[:-k]
    return ''.join(stack)