# 최댓값 만들기 (1)
def solution(numbers):
    numbers.sort(reverse = True)
    numbers = [num for num in numbers]
    return numbers[0]*numbers[1]

# 람다 연습하기
def solution(numbers):
    return (lambda x: x[0] * x[1])(sorted([num for num in numbers], reverse=True))

numbers = [0, 31, 24, 10, 1, 9]

print(solution(numbers))

