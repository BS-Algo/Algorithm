# 1로 만들기
def solution(num_list):
    answer = 0
    for num in num_list:
        while num > 1:
            if num % 2 == 0:
                num /= 2
                answer += 1
            elif num % 2 == 1:
                num -= 1
                num /= 2
                answer += 1
    return answer

num_list = [12, 4, 15, 1, 14]	
print(solution(num_list))