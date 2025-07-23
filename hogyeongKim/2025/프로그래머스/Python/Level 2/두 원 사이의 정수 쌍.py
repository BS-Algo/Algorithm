import math
def solution(r1, r2):
    answer = 0
    for x in range(1, r2+1):
        mx_y = int((r2**2-x**2)**0.5)
        if x < r1:
            mn_y = math.ceil((r1**2-x**2)**0.5)
        else:
            mn_y = 1
        answer += mx_y - mn_y + 1
    return 4*(answer + (r2-r1+1))