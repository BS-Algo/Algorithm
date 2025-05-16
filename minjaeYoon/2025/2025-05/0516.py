# 조건에 맞게 수열 변환하기 3
def solution(arr, k):
    if k % 2 == 1:
        arr = [x*k for x in arr]
    else:
        arr = [x+k for x in arr]
    return arr

arr = [1, 2, 3, 100, 99, 98]	
k = 3

print(solution(arr, k))