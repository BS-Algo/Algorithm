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

# 정처기 실기 파이썬 코딩 예상문제 분석 (리스트, for 반복문)
box = [[1,2,3],[4,5,6],[7,8,9]]
for line in box:
    for col in line:
        print(col, end="")
        
# List는 파이썬에서 하나의 객체로 취급