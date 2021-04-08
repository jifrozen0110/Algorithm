n=input()
length=len(n)
left,right=0,0
for i in range (length//2):
    left+=int(n[i])
for j in range (length//2,length):
    right+=int(n[j])

if left==right:
    print("LUCKY")
else:
    print("READY")

