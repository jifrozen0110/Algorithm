A,B,V=map(int,input().split())

V=V-B

print(V//(A-B)+(1 if V%(A-B)>0 else 0))