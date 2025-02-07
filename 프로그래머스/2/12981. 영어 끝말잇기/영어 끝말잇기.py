def solution(n, words):
    answer = [0,0]

    lastWord=words[0][0]
    ms=set()
    for i in range (len(words)):
        if lastWord!=words[i][0] or words[i] in ms:
            answer[0]=i%n+1
            answer[1]=i//n+1
            return answer
        ms.add(words[i])
        lastWord=words[i][len(words[i])-1]

    return answer