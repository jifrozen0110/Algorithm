count=0
word_list=['A', 'E', 'I', 'O', 'U']
    
def solution(word):
    DFS("",word)
    return answer

def DFS(word,target):
    global answer,count
    if word==target:
        answer=count
        return
    if len(word)>=5:
        return;
    for i in range (len(word_list)):
        count+=1
        DFS(word+word_list[i],target)