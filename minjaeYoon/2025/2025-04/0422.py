# 길이에 따른 연산
def solution(num_list):
    answer = 1
    if len(num_list) >= 11:
        return sum(num_list)
    elif len(num_list) <= 10:
        for num in num_list:
            answer *= num
    return answer

num_list = [3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1]

print(solution(num_list))