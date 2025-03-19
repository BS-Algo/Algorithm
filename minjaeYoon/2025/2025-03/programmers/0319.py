# 등차수열의 특정한 항만 더하기
def solution(a, d, included):
    res = 0
    for i in range(len(included)):
        if included[i]:
            res += a + d*i
    return res

a = 3
d = 4
included = [True, False, False, True, True]

print(solution(a, d, included))