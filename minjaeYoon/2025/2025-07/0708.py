# 짝수는 싫어요
def solution(n):
    return [num for num in range(n+1) if num % 2 == 1]

n = 15

print(solution(n))

# 배열 두 배 만들기
def solution(numbers):
    return [i*2 for i in numbers]

# 배열의 평균값
def solution(numbers):
    return sum(numbers) / len(numbers)

# 중앙값 구하기
def solution(array):
    array.sort()
    return array[len(array)//2]

array = [1, 2, 7, 10, 11]

print(solution(array))

# 최빈값 구하기
def solution(array):
    arr_dic = {x: array.count(x) for x in set(array)}
    mx_arr_count = max(arr_dic.values())
    mx_arr_key = [k for k, v in arr_dic.items() if v == mx_arr_count]
    
    return -1 if len(mx_arr_key) > 1 else mx_arr_key[0]

array = [1, 1, 2, 2]

print(solution(array))
