def solution(name):
    answer = 0
    n=len(name)
    move=n-1
    
    for c in range (n):
        a=abs(ord('A')-ord(name[c]))
        b=abs(ord('Z')-ord(name[c]))+1
        
        answer+=min(a,b)
        
        next=c+1
        while next<n and name[next]=='A':
            next+=1
            
        move=min(move,c*2+n-next)
        move=min(move,(n-next)*2+c)
        
    return answer+move