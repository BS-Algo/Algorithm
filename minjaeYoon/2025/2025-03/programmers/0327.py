# 문자열의 앞의 n글자
def solution(my_string, n):
    return my_string[:n]

my_string = "ProgrammerS123"
n = 11

print(solution(my_string, n))

# 접두사인지 확인하기
def solution(my_string, is_prefix):
    answer = []
    res = 0
    for i in range(len(my_string)):
        answer.append(my_string[i:])
        if is_prefix in my_string:
            res = 1
        else:
            res = 0
    return res

# 문자열 뒤집기
def solution(my_string, s, e):
    answer = ''
    pos = len(my_string)
    change = my_string[e-pos:s-pos-1:-1]
    answer = my_string[:s] + change + my_string[e+1:]
    return answer

# change = my_string[s:e+1][::-1] 슬라이싱 뒤집기

my_string = "Progra21Sremm3"
s = 6
e = 12

print(solution(my_string, s, e))
