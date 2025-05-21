# 문자열 계산하기
def solution(my_string):
    answer = 0
    my_string = my_string.replace('-', ' -').replace('+', ' +')
    my_string = list(map(str, my_string.split()))
    if my_string[1] == '+':
        answer = int(my_string[0]) + int(my_string[2])
    elif my_string[1] == '-':
        answer = int(my_string[0]) - int(my_string[2])
    return answer

my_string = "3 + 4"

print(solution(my_string))

def solution(my_string):
    return sum(int(i) for i in my_string.replace(' - ', ' + -').split(' + '))