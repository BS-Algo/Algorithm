# 소수 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/12921
def solution(n):
    answer = 0
    def isprime(n):
        if n < 2:
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False

        for i in range(3, int(n**0.5) + 1, 2):
            if n % i == 0:
                return False
        return True
    
    for i in range(1, n+1):
        if isprime(i):
            answer += 1
    return answer

print(solution(10))

# 에라토스테네스의 체
def solution(n):
    num=set(range(2,n+1))

    for i in range(2,n+1):
        if i in num:
            num-=set(range(2*i,n+1,i))
    return len(num)