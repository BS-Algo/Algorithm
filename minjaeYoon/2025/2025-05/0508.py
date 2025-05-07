# 배열의 길이에 따라 다른 연산하기
def solution(arr, n):
    if len(arr) % 2 == 1:
        for i in range(0, len(arr), 2):
            arr[i] += n
    elif len(arr) % 2 == 0:
        for i in range(1, len(arr), 2):
            arr[i] += n
    return arr

arr = [49, 12, 100, 276, 33]	
n = 27

print(solution(arr, n))

# 뒤에서 5등까지
def solution(num_list):
    for i in range(len(num_list)-1):
        # for j in range(1, len(num_list)):
        if num_list[i] > num_list[i+1]:
            num_list[i], num_list[i+1] = num_list[i+1], num_list[i]
                
    return num_list

num_list = [12, 4, 15, 46, 38, 1, 14]	

print(solution(num_list))