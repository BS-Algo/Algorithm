# 간단한 식 계산하기
def solution(binomial):
    answer = 0
    binomial = binomial.split()
    # a, op, b = binomial.split()
    
    a = int(binomial[0])
    op = binomial[1]
    b = int(binomial[2])
    
    if op == '+':
        return a + b
    elif op == '-':
        return a - b
    elif op == '*':
        return a * b
    return ""

binomial = "43 + 12"	

print(solution(binomial))

# 문자열 바꿔서 찾기
def solution(myString, pat):
    result = ""
    
    for char in myString:
        if char == 'A':
            result += 'B'
        elif char == 'B':
            result += 'A'
        else:
            result += char
            
    if pat in result:
        return 1
    else:
        return 0

myString = "ABBAA"
pat = "AABB"

print(solution(myString, pat))

# rny_string
def solution(rny_string):
    answer = ''
    rny_string = list(rny_string)
    
    for i in range(len(rny_string)):
        if rny_string[i] == 'm':
            rny_string[i] = 'rn'
    
    answer = ''.join(rny_string)
    
    return answer

rny_string = "masterpiece"

print(solution(rny_string))