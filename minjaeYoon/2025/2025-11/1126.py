# 시저 암호
# https://school.programmers.co.kr/learn/courses/30/lessons/12926
def solution(s, n):
    answer = ''
    s = list(s)
    for lan in s:
        if lan == ' ':
            answer += lan
        elif lan.isupper():
            tmp = ord(lan) + n
            if tmp > 90:
                tmp = tmp - 90 + 65 - 1
            answer += chr(tmp)
        elif lan.islower():
            tmp = ord(lan) + n
            if tmp > 122:
                tmp = tmp - 122 + 97 - 1
            answer += chr(tmp)
        
    return answer

print(solution("AB", 1))
