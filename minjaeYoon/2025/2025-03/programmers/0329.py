# QR 코드
def solution(q, r, code):
    answer = ''
    for i in range(len(code)):
        if i%q == r:
            answer += code[i]
    return answer

def solution2(q, r, code):
    return code[r::q]

q = 3
r = 1
code = "qjnwezgrpirldywt"

print(solution(q, r, code))

# 문자 개수 세기
def solution(my_string):
    answer = [0] * 52
    for char in my_string:
        if char.isupper():
            num = ord(char) - ord('A')
            answer[num] += 1
        else:
            num = ord(char) - ord('a') + 26
            answer[num] += 1
    return answer

my_string = "Programmers"

print(solution(my_string))