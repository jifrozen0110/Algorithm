n,k=map(int,input().split())

a=list(map(int,input().split()))
b=list(map(int,input().split()))


a=sorted(a,reverse=True)
b=sorted(b,reverse=True)

print(sum(a[:len(a)-k])+sum(b[:k]))



