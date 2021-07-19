array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

# 선택정렬
for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]



#삽입 정렬
for i in range (1,len(array)): # j 현재 삽입하고자 하는 데이터
    for j in range (i,0,-1): # 인덱스 i부터 1까지 -1씩 감소하며 반복
        if array[j]<array[j-1]:  # 현재 삽입하고자 하는 데이터와 바로 왼쪽 데이터 비교해서 작으면
            array[j],array[j-1]=array[j-1],array[j] # 왼쪽 데이터와 바꿈
        else: # 크면
            break # 그대로


# 퀵 정렬
def quick_sort(array, start,end):
    if start>=end:
        return
    pivot=start
    left=start+1
    right=end
    while(left<=right): # left가 right 보다 커진다면
        # 선형탐색 피봇보다 왼쪽에서 큰 값을 찾을때까지
        while(left<=end and array[left]<=array[pivot]):
            left+=1
        while(right>start and array[right]>=array[pivot]):
            right-=1
        if (left>right): # 엇갈렸다면 작은 데이터와 피봇 대체
            array[right],array[pivot]=array[pivot],array[right]
        else:
            array[left],array[pivot]=array[right],array[left]
    # 재귀적으로 왼쪽 오른쪽 각각 정렬 다시
    quick_sort(array,start,right-1)
    quick_sort(array,right+1,end)


# 파이썬의 장점을 살린 퀵정렬
def quick_sort2(array):
    if len(array)<=1:
        return array
    pivot =array[0]
    tail=array[1:0] # 피봇을 제외한 리스트

    left_side=[x for x in tail if x<=pivot]
    right_side=[x for x in tail if x>pivot]

    return quick_sort2(left_side)+[pivot]+quick_sort2(right_side)


quick_sort(array,0,len(array)-1)


# 계수 정렬
count=[0]*(max(array)+1)

for i in range (len(array)):
    count[array[i]]+=1

for i in range (len(count)):
    for j in range (count[i]):
        print(i,end='')




print(array)