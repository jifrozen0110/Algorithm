import sys

def add(x,y):
    return x+y

def subtract(x,y):
    return x-y

def multiply(x,y):
    return x*y

def divide(x,y):
    return x//y

def modulo(x,y):
    return x%y;

def main():
    a,b=map(int, sys.stdin.readline().split())

    print(add(a,b));
    print(subtract(a,b));
    print(multiply(a,b));
    print(divide(a,b));
    print(modulo(a,b));

if __name__ == "__main__":
    main()