# 숫자 문자열과 영단어
# https://school.programmers.co.kr/learn/courses/30/lessons/81301
def solution(s):
    n_to_w = {
        'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4',
        'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'
    }
    answer = ''
    tmp = ''
    
    for char in s:
        if char.isdigit():
            answer += char
            tmp = ''
        else:
            tmp += char
            
            if tmp in n_to_w:
                answer += n_to_w[tmp]
                tmp = ''
    
    return answer

print(solution("one4seveneight"))