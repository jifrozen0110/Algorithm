def factorial(num):
    if num>1:
        return num*factorial(num-1)
    else:
        return 1

def main():
    num=int(input())

    print(factorial(num))

if __name__=='__main__':
    main()