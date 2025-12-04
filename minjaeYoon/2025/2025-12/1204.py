# 콜라 문제
# https://school.programmers.co.kr/learn/courses/30/lessons/132267
def solution(a, b, n):
    answer = 0
    return (n - a) // (a - b) * b + b

print(solution(2, 1, 20))

# 람다식
solution = lambda a, b, n: max(n - b, 0) // (a - b) * b
