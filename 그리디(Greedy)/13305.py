n=int(input())
road=list(map(int,input().split()))
price=list(map(int,input().split()))
p=price[0]
r=road[0]
cost=p*r

for i in range (1,len(price)-1):
    if price[i]<p:
        cost+=price[i]*road[i]
        p=price[i]
    else:
        cost+=p*road[i]

print(cost)
