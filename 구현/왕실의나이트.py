input_data=input()
row=int(input_data[1])
column=int(ord(input_data[0]))-int(ord('a'))+1
case=[(2,-1),(2,1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]
result=0
for c in case:
    if 8>=row+c[0]>0 and 8>=column+c[1]>0:
        result+=1

print(result)