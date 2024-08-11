
import sys

def main():
    input=sys.stdin.readline
    N=int(input())
    list=[0]*10001

    for _ in range (N):
        list[int(input())]+=1

    for i in range (10001):
        if list[i]!=0:
            for _ in range (list[i]):
                print(i)



if __name__=="__main__":
    main()


