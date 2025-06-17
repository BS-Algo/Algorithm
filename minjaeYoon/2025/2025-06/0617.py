# 최댓값 만들기 (2)
def solution(numbers):
    answer = 0
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i !=j:    
                if answer <= numbers[i] * numbers[j]:
                    answer = numbers[i] * numbers[j]
    return answer

numbers = [1, 2, -3, 4, -5]

print(solution(numbers))

# lambda: x 