n = int(input())
data = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))


def binary_search(data, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return mid
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None


data.sort()
for i in target:
    result = binary_search(data, i, 0, n - 1)
    if result == None:
        print("No", end=' ')
    else:
        print("yes", end=' ')
