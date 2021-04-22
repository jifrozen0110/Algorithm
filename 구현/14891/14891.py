# https://www.acmicpc.net/problem/14891
# Gold V

def check_turn(start):
    if start+1<4:
        if turn[start+1]==0 and data[start][2] != data[start + 1][6]:
            turn[start+1]=turn[start]*-1
            check_turn(start+1)
    if start-1>=0:
        if turn[start-1]==0 and data[start][6] != data[start - 1][2]:
            turn[start-1]=turn[start]*-1
            check_turn(start-1)


# def clock_right(data, clock, start):
#     print(start)
#     if clock == -1:
#         data[start][7], data[start][0], data[start][1], data[start][2], data[start][3], data[start][4], data[start][5], \
#         data[start][6] = data[start][0], data[start][1], data[start][2], data[start][3], \
#                          data[start][4], data[start][5], data[start][6], data[start][7]
#     else:
#         data[start][0], data[start][1], data[start][2], data[start][3], data[start][4], data[start][5], data[start][6], \
#         data[start][7] = data[start][7], data[start][0], data[start][1], data[start][2], \
#                          data[start][3], data[start][4], data[start][5], data[start][6]
#     if start >= 3 or data[start][2] == data[start + 1][6]:
#         return
#     else:
#         for j in range(start, 0):
#             clock_right(data, clock*-1, start+1)
#             check_turn(data, clock, start)
#
#
# def clock_left(data, clock, start):
#     print("왼쪽",start)
#     if start <= 0 or data[start][6] == data[start - 1][2]:
#         return
#     else:
#         for j in range(start, 0):
#             clock_left(data, clock*-1, start-1)
#             check_turn(data, clock, start)


data = []
for i in range(4):
    data.append(list(input()))


n = int(input())
for i in range(n):
    start, clock = map(int, input().split())
    turn=[0 for _ in range (4)]
    start = start - 1
    turn[start]=clock
    check_turn(start)
    for t in range (len(turn)):
        if turn[t]==0:
            continue
        if turn[t] == -1:
            data[t][7], data[t][0], data[t][1], data[t][2], data[t][3], data[t][4], data[t][5], \
            data[t][6] = data[t][0], data[t][1], data[t][2], data[t][3], \
                             data[t][4], data[t][5], data[t][6], data[t][7]
        elif turn[t]==1:
            data[t][0], data[t][1], data[t][2], data[t][3], data[t][4], data[t][5], data[t][6], \
            data[t][7] = data[t][7], data[t][0], data[t][1], data[t][2], \
                             data[t][3], data[t][4], data[t][5], data[t][6]

result=0
for d in range (len(data)):
    if data[d][0]=='1':
        result+=pow(2,d)
    else:
        result+=0

print(result)
