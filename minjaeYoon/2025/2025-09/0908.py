# 문자열 내림차순으로 배치하기
# https://school.programmers.co.kr/learn/courses/30/lessons/12917
def solution(s):
    return ''.join(sorted(s, reverse=True))

print(solution("Zbcdefg"))

# 부족한 금액 계산하기
# https://school.programmers.co.kr/learn/courses/30/lessons/82612
def solution(price, money, count):
    for i in range(1, count+1):
        current = price * i
        money -= current
    return abs(money) if money < 0 else 0

print(solution(3, 20, 4)) # 10

# 문자열 다루기 기본
# https://school.programmers.co.kr/learn/courses/30/lessons/12918
def solution(s):
    answer = True
    if len(s) == 4 or len(s) == 6:
        if s.isdigit():
            return answer
        else:
            return False
    return False

def solution(s):    
    return s.isdigit() and len(s) in [4,6]

print(solution("a234"))

