def solution(board, skill):
    answer = 0
    
    arrSum=[[0]*(len(board[0])+1) for _ in range (len(board)+1)]
    
    
    for s in skill:
        type,r1,c1,r2,c2,degree=s
        if type==1:
            degree=-degree
        arrSum[r1][c1]+=degree
        arrSum[r1][c2+1]-=degree
        arrSum[r2+1][c1]-=degree
        arrSum[r2+1][c2+1]+=degree
      
    for i in range (len(board)+1):
        for j in range (1,len(board[0])+1):
            arrSum[i][j]+=arrSum[i][j-1]

    
    
    for i in range (len(board[0])+1):
        for j in range (1,len(board)+1):
            arrSum[j][i]+=arrSum[j-1][i]
            

    for i in range (len(board)):
        for j in range (len(board[0])):        
            board[i][j]+=arrSum[i][j]
            if board[i][j]>0:
                answer+=1

    
    return answer