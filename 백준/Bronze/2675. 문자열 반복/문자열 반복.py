T=int(input())

for _ in range(T):
    a=input().split()
    strVal=""
    for s in a[1]:
        for num in range(int(a[0])):
            strVal+=s
    print(strVal)
