# 문자열의 뒤의 n글자
def solution(my_string, n):
    answer = ''
    return answer.join(my_string[len(my_string)-n::])

my_string = "ProgrammerS123"
n = 11

print(solution(my_string, n))