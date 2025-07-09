# 중복된 숫자 개수
def solution(array, n):
    arr_dic = {x: array.count(x) for x in set(array)}
    return arr_dic.get(n, 0)

array = [1, 1, 2, 3, 4, 5]
n = 1

print(solution(array, n))