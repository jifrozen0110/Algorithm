def possible(result):
    for x, y, a in result:
        if a == 0:
            if y == 0 or [x - 1, y, 1] in result or [x, y, 1] in result or [x, y - 1, 0] in result:
                continue
            else:
                return False
        else:
            if [x, y - 1, 0] in result or [x + 1, y - 1, 0] in result or (
                    [x - 1, y, 1] in result and [x + 1, y, 1] in result):
                continue
            else:
                return False
    return True


def solution(n, build_frame):
    result = []
    for x, y, a, b in build_frame:
        if b == 0:
            result.remove([x, y, a])
            if not possible(result):
                result.append([x, y, a])
        else:
            result.append([x, y, a])
            if not possible(result):
                result.remove([x, y, a])
    return sorted(result)


print(solution
      (5,
       [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1], [2, 0, 0, 0],
        [1, 1, 1, 0], [2, 2, 0, 1]]
       )
      )
