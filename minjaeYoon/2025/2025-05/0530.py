# 가까운 수
def solution(array, n):
    min_val = 999999
    res = 999999
    
    for val in array:
        diff = abs(val-n)
        if diff < min_val or (diff == min_val and val < res):
            min_val = diff
            res = val
    
    return res

array = [3, 10, 28]
n = 20

print(solution(array, n))

# 람다 활용
def solution(array, n):
    array.sort(key = lambda x : (abs(x-n), x-n))
    answer = array[0]
    return answer