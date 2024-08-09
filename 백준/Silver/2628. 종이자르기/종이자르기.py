import sys

input=sys.stdin
w,h=map(int,input.readline().split())

T=int(input.readline())

cuttings=[list(map(int,input.readline().split())) for _ in range(T)]


widths=[0,w]
hegiths=[0,h]
for cutting in cuttings:
    if cutting[0]==1:
        widths.append(cutting[1])
    else:
        hegiths.append(cutting[1])


wGap,hGap=0,0;
widths.sort()
hegiths.sort()
for i in range(0,len(widths)-1):
    if wGap<(widths[i+1]-widths[i]):
        wGap=(widths[i+1]-widths[i])


for i in range(0,len(hegiths)-1):
    if hGap<(hegiths[i+1]-hegiths[i]):
        hGap=(hegiths[i+1]-hegiths[i])

print(hGap*wGap)

