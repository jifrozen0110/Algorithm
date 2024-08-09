n=int(input())

flag_w=[False]*n
flag_a=[False]*(n*2-1)
flag_b=[False]*(n*2-1)

pos=[0]*n
answer=0

def set(i):
    global answer
    for j in range(n):
        if (not flag_w[j] and not flag_a[i+j] and not flag_b[i-j+(n-1)]):
            pos[j]=i
            if i==n-1:
                answer+=1
            else:
                flag_w[j]=True
                flag_a[i+j]=True
                flag_b[i-j+(n-1)]=True
                set(i+1)
                flag_w[j]=False
                flag_a[i+j]=False
                flag_b[i-j+(n-1)]=False


set(0)
print(answer)




