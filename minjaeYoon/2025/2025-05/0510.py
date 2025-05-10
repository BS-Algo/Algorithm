# 문자열 정수의 합
def solution(num_str):
    num_str = list(map(int, num_str))
    return sum(num_str)

num_str = "123456789"

print(solution(num_str))

# 정수 부분
def solution(flo):
    return int(flo)

# 문자열을 정수로 변환하기
def solution(n_str):
    return int(n_str)

n_str = "10"

print(solution(n_str))

# 0 떼기
def solution(n_str):
    n_str = int(n_str)
    return f"{n_str}"

n_str = "0010"

print(solution(n_str))

# 두 수의 합
def solution(a, b):
    a, b = int(a), int(b)
    return f"{a+b}"

a = "582"
b = "734"

print(solution(a, b))