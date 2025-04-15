# n보다 커질 때 까지 더하기
def solution(numbers, n):
    answer = 0
    for number in numbers:
        answer += number
        if answer > n:
            return answer
    return answer

numbers = [34, 5, 71, 29, 100, 34]	
n = 123

print(solution(numbers, n))