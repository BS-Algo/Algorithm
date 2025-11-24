# 3진법 뒤집기
# https://school.programmers.co.kr/learn/courses/30/lessons/68935
def solution(n):
    answer = 0
    def to_n(n, b):
        if n == 0:
            return 0
        
        dig = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        res = ''
        
        while n > 0:
            res = dig[n % b] + res
            n //= b
        
        return res
    
    n = to_n(n, 3)
    n = ''.join(reversed(n))
    
    answer = int(n, 3)
    
    return answer

print(solution(45))
print(solution(125))

# 간략한 풀이
def solution(n):
    tmp = ''
    while n:
        tmp += str(n % 3)
        n = n // 3

    answer = int(tmp, 3)
    return answer