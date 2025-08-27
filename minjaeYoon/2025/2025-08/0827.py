# 문자열을 정수로 바꾸기
def solution(s):
    return int(s) 

print(solution('1234'))
print(solution('-1234'))

# 약수의 합
def solution(n):
    answer = 0
    for i in range(1, n+1):
        if n % i == 0:
            answer += i
    return answer

print(solution(12))

# 정수 내림차순으로 배치하기
def solution(n):
    n = sorted(list(map(str, str(n))), reverse=True)
    return int(''.join(n))

print(solution(118372))

# 두 정수 사이의 합
def solution(a, b):
    answer = 0
    miv = min(a, b)
    mav = max(a, b) + 1
    for i in range(miv, mav):
        answer += i
    return answer

print(solution(5, 3))

# 문자열 내 p, y 개수
def solution(s):
    s = s.lower()
    p = s.count('p')
    y = s.count('y')
    
    return True if p == y else False

print(solution("pPoooyY"))

# 정수 제곱근 판별
def solution(n):
    rn = n ** 0.5
    return int((rn+1) ** 2) if rn == int(rn) else -1

print(solution(121))