# 처음 끝 배열 인덱스 찾아서 빼주기
def count_by_value(array, x):
    n = len(array)

    a = first(array, x, 0, n - 1)
    if a == None:
        return 0
    b = last(array, x, 0, n - 1)

    return b - a + 1

# 첫번째 시작 원소 찾기
def first(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    # mid == 0 첫번째 원소이거나 mid-1원소 내 왼쪽 원소가 나보다 작으면 그리고 mid 인덱스 배열값이 찾는값이여야함
    if (mid == 0 or target > array[mid - 1]) and array[mid] == target:
        return mid
    elif array[mid] >= target:
        return first(array, target, start, mid - 1)
    else:
        return first(array, target, mid + 1, end)

# 마지막 원소 찾기
def last(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if (mid == n - 1 or target < array[mid + 1]) and array[mid] == target:
        return mid
    elif array[mid] > target:
        return last(array, target, start, mid - 1)
    else:
        return last(array, target, mid + 1, end)


n, x = map(int, input().split())
data = list(map(int, input().split()))

count = count_by_value(data, x)
if count == 0:
    print(-1)
else:
    print(count)
