# 구슬을 나누는 경우의 수
def solution(balls, share):
    
    def fac(n):
        res = 1
        for i in range(1, n+1):
            res *= i
        return res
    
    answer = 0
    
    a = balls
    b = balls - share
    c = share
    
    answer = fac(a) / (fac(b) * fac(c))
    
    return int(answer)

balls = 5
share = 3

print(solution(balls, share))

# math 메서드 활용
import math


def solution(balls, share):
    return math.comb(balls, share)