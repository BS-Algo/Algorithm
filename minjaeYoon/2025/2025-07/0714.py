# 외계행성의 나이
def solution(age):
    num_to_alpha = {
    0: 'a',
    1: 'b',
    2: 'c',
    3: 'd',
    4: 'e',
    5: 'f',
    6: 'g',
    7: 'h',
    8: 'i',
    9: 'j'
}
    answer = ''
    for digit in str(age):
        answer += num_to_alpha[int(digit)]
    return answer

age = 23

print(solution(age))