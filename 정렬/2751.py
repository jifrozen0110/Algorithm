import sys

n = int(input())
data = [int(sys.stdin.readline()) for _ in range(n)]

data.sort()
for i in data:
    print(i)
# def quick_sort(data):
#     if len(data)<=1:
#         return data
#     pivot=data[0]
#     tail=data[1:]
#
#     left_side=[x for x in tail if x<=pivot]
#     right_side=[x for x in tail if x>pivot]
#
#     return quick_sort(left_side)+[pivot]+quick_sort(right_side)
#
#
# print(quick_sort(data))
#
# # 삽입 정렬로 풀면
# for j in range (len(data)):
#     min_index=j
#     for k in range (j+1,len(data)):
#         if data[min_index]>data[k]:
#             min_index=k
#     data[j],data[min_index]=data[min_index],data[j]
#
# print(data)
