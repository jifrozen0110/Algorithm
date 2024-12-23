import sys
def checkExam(num):
    if num>=90:
        return "A"
    elif num>=80:
        return "B"
    elif num>=70:
        return "C"
    elif num>=60:
        return "D"
    else:
        return "F"

def main():
    num=int(sys.stdin.readline())
    print(checkExam(num))

if __name__=="__main__":
    main()